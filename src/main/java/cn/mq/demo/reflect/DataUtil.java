package cn.mq.demo.reflect;

/**
 * Created by qiangzi on 16/6/15.
 */
public class DataUtil {

    public static Integer toInteger(String str){
        try{
            return Integer.parseInt(str);
        }
        catch (Exception e){
            return null;
        }
    }

    public static Long toLong(String str){
        try{
            return Long.parseLong(str);
        }
        catch (Exception e){
            return null;
        }
    }

    public static Double toDouble(String str){
        try{
            return Double.parseDouble(str);
        }
        catch (Exception e){
            return null;
        }
    }

    public static Float toFloat(String str){
        try{
            return Float.parseFloat(str);
        }
        catch (Exception e){
            return null;
        }
    }

    public static Boolean toBoolean(String str){
        try{
            return Boolean.parseBoolean(str);
        }
        catch (Exception e){
            return null;
        }
    }

    public static int toIntValue(String str,int defaultVal){
        Integer rst = toInteger(str);
        return rst == null ? defaultVal : rst;
    }

    public static int toIntValue(String str){
        return toIntValue(str, -1);
    }

    public static long toLongValue(String str,long defaultVal){
        Long rst = toLong(str);
        return rst == null ? defaultVal : rst;
    }

    public static long toLongValue(String str){
        return toLongValue(str, -1);
    }

    public static double toDoubleValue(String str,double defaultVal){
        Double rst = toDouble(str);
        return rst == null ? defaultVal : rst;
    }

    public static float toFloatValue(String str, float defaultVal){
        Float rst = toFloat(str);
        return rst == null ? defaultVal : rst;
    }

    public static boolean toBooleanValue(String str,boolean defaultValue){
        Boolean rst = toBoolean(str);
        return rst == null ? defaultValue : rst;
    }

    public static boolean toBooleanValue(String str){
        return toBooleanValue(str, false);
    }

}
