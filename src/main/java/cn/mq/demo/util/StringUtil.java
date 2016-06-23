package cn.mq.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiangzi on 16/6/17.
 */
public class StringUtil {

    //判断是否为空
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str)){
            return true;
        }
        return false;
    }

    //判断不为空
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    //判断字符串为空串
    public static boolean isBlank(String str){
        if(isEmpty(str)){
            return true;
        }
        if(Pattern.matches("\\s+", str)){
            return true;
        }
        return false;
    }

    //判断字符串不为空串
    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

    //统计出现次数
    public static int count(String str,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while(matcher.find()){
            count ++;
        }
        return count;
    }

    //获取字符串内容,如果为空,则返回指定的默认值
    public static String getString(String str,String defaultVal){
        if(isEmpty(str)){
            return defaultVal;
        }
        return str;
    }

}
