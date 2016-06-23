package cn.mq.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by qiangzi on 16/6/17.
 */
public class FileUtil {

    public static String readFile(File file){
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bts = new byte[1024];
            StringBuffer sbf = new StringBuffer();
            int len = 0;
            while((len = fis.read(bts)) != -1){
                sbf.append(new String(bts, 0, len));
            }
            return sbf.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
