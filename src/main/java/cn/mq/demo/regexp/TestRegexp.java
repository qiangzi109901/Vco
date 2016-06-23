package cn.mq.demo.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiangzi on 16/6/17.
 */
public class TestRegexp {


    public static void main(String[] args) {

        String str = "Hello do you do";

        Pattern pattern = Pattern.compile("d");

        Matcher matcher = pattern.matcher(str);

        int count = 0;
        while(matcher.find()){
            count ++;
        }
        System.out.println(count);
        System.out.println(matcher.find());
        int c = matcher.groupCount();

        System.out.println(c);
        System.out.println(matcher.matches());

        pattern = Pattern.compile("\\w+");

        matcher = pattern.matcher(str);
        System.out.println(matcher.matches());

    }
}
