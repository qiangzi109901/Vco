package cn.mq.demo.reflect;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by qiangzi on 16/6/15.
 */
public class RefectUtil {
    private static final int type_char = 0;
    private static final int type_string = 1;
    private static final int type_int = 2;
    private static final int type_boolean = 3;
    private static final int type_long = 4;
    private static final int type_double = 5;
    private static final int type_float = 6;
    private static final int type_map = 7;
    private static final int type_list = 8;
    private static final int type_set = 9;
    private static final int type_date = 10;

    public static final Map<String,Integer> typeMap = new HashMap();
    static {
        typeMap.put("char", type_char);
        typeMap.put("Character", type_char);
        typeMap.put("String", type_string);
        typeMap.put("Integer", type_int);
        typeMap.put("int", type_int);
        typeMap.put("Boolean", type_boolean);
        typeMap.put("boolean", type_boolean);
        typeMap.put("Float",type_float);
        typeMap.put("float",type_float);
        typeMap.put("Double", type_double);
        typeMap.put("double", type_double);
        typeMap.put("Long", type_long);
        typeMap.put("long", type_long);
        typeMap.put("List", type_list);
        typeMap.put("ArrayList", type_list);
        typeMap.put("Map", type_map);
        typeMap.put("HashMap", type_map);
        typeMap.put("Set", type_set);
        typeMap.put("HashSet", type_set);
        typeMap.put("Date", type_date);
    }

    //根据字段获取set方法
    public static String getSetMethod(String  fieldName){
        return "set" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1);
    }

    //根据字段获取get方法
    public static String  getGetMethod(String fieldName){
        return "get" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1);
    }


    //通过反射设置对象的属性值
    public static void setter(Object target, Field field, Object value){
        setter(target, field.getName(), field.getType(), value);
    }


    //通过反射设置对象的属性值
    public static void setter(Object target, String fieldName, Class<?> fieldType, Object value){
        try {
            Object rightVal = getRightFieldValue(fieldType, value);
            Method method = target.getClass().getDeclaredMethod(getSetMethod(fieldName),fieldType);
            method.invoke(target, rightVal);
        } catch (IllegalArgumentException e){
            System.err.println(fieldName + "类型错误,则跳过赋值");
        } catch (Exception e){
            System.err.println("最终错误");
        }
    }

    //通过反射获取对象的属性值
    public static Object getter(Object target, String fieldName){
        try {
            Method method = target.getClass().getDeclaredMethod(getGetMethod(fieldName));
            return method.invoke(target);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static int getObjectType(Object val){
        return getIntType(val.getClass());
    }

    public static boolean isNormalType(Class<?> cls){
        return getIntType(cls) >= 0;
    }

    public static int getIntType(Class<?> cls){
        Integer result = typeMap.get(cls.getSimpleName());
        if(result == null){
            return -1;
        }
        return result;
    }

    public static Object getRightFieldValue(Class<?> fieldClassType,Object val){
        if(val == null){
            return null;
        }
        int fieldType = getIntType(fieldClassType);
        int valType = getObjectType(val);

        //两者类型相同,直接返回
        if(fieldType == valType){
            return val;
        }

        Object rst = val;
        if(valType == type_string){
            String mval = (String)val;
            rst = DataUtil.toInteger(mval);
            if(rst == null){
                rst = DataUtil.toDouble(mval);
                if(rst == null){
                    rst = DataUtil.toFloat(mval);
                    if(rst == null){
                        rst = DataUtil.toLong(mval);
                    }
                }
            }
            if(rst == null){
                return null;
            }
            valType = getObjectType(rst);
            //再次比较两者类型
            if(fieldType == valType){
                return rst;
            }
        }

        //自动转型
        if(fieldType == type_long || fieldType == type_float || fieldType == type_double){
            if(valType == type_int){
                return rst;
            }
        }

        //自动转型
        if(fieldType == type_double && valType == type_float){
            return rst;
        }

        //向下转型
        if(fieldType == type_int){
            if(valType == type_long){
                //将long 转为 int
                return new Integer( ((Long)rst).intValue() );
            }
        }

        //double 转 float
        if(fieldType == type_float){
            if(valType == type_double){
                return new Float( ((Double)rst).floatValue() );
            }
        }
        return null;
    }

    public static <T> T map2obj(Map<String,Object> data, Class<T> cls){
        T t = null;
        try {
            t = cls.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        if(t == null){
            return null;
        }

        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields){
            String fieldName = field.getName();
            if(data.containsKey(fieldName)){
                setter(t, field, data.get(fieldName));
            }
        }
        return t;
    }

    public static Map<String,Field> getFieldsMap(Class<?> cls){
        Field[] fields = cls.getDeclaredFields();
        Map<String,Field> ms = new HashMap<>();
        for(Field s : fields){
           ms.put(s.getName(), s);
        }
        return ms;
    }


    public static <T> T deepMap2obj(Map<String,Object> data, Class<T> cls){
        T t = map2obj(data, cls);
        Table<String,String,Object> childValues = HashBasedTable.create();
        Field[] fields = cls.getDeclaredFields();
        for(String key : data.keySet()){
            if(key.contains(".")){
                String fieldName = key.substring(0, key.indexOf("."));
                String childFieldName = key.substring(key.indexOf(".") + 1);
                childValues.put(fieldName, childFieldName, data.get(key));
            }
        }
        if(childValues.size() == 0){
            return t;
        }
        Map<String, Field> fieldMaps = getFieldsMap(cls);
        //拿到所有的对象名
        Set<String> rows = childValues.rowKeySet();
        for(String row:rows){
            Field childField = fieldMaps.get(row);
            //表示存在此对象
            if(fieldMaps.containsKey(row) && !isNormalType(childField.getType())){
                Map<String,Object> childVal = childValues.row(row);
                Object child = map2obj(childVal, childField.getType());
                setter(t, childField, child);
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Map<String,Object> data = new HashMap<>();
        data.put("name", "张三");
        data.put("age", 20);
        data.put("workYear", 2);
        data.put("birthday", new Date());
        data.put("gender",'A');
        data.put("time", 33222l);
        data.put("money", 33112.33f);
        data.put("salary", 2211.434d);

        data.put("grade.id", 1);
        data.put("grade.name","一年级");

        data.put("grade2.id", 2);
        data.put("grade2.name","二年级");
        User user = deepMap2obj(data, User.class);
        System.out.println(user);
    }



}
