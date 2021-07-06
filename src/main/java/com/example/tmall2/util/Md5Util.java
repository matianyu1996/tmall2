package com.example.tmall2.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

@Slf4j
public abstract class Md5Util {

    private static final String hexDigits = "012356789abcdef";
    private static final String MD5 = "MD5";
    public static String Md5Encode(String origin, String charsetName){
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance(MD5);
            if(StringUtils.isEmpty(charsetName)){
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }
            else{
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetName)));
                //String test = byteArrayToHexString(md.digest(resultString.getBytes(charsetName)));
                //log.info(test);
            }
        }
        catch(Exception exception){}
        //log.info(resultString);
        return resultString;
    }

    private static String byteArrayToHexString(byte bytes[]){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < bytes.length-1; i++){
           stringBuffer.append(byteToHexString(bytes[i]));
            log.info(stringBuffer.toString());
        }
        log.info("test");

        return stringBuffer.toString();
    }

    private static String byteToHexString(byte byteVar){
        int n = byteVar;
        n += 128;
        int d1 = n/16;
        int d2 = n%16;
        log.info(StringUtils.EMPTY+ hexDigits.charAt(d1)+hexDigits.charAt(d2));
        return StringUtils.EMPTY+ hexDigits.charAt(d1)+hexDigits.charAt(d2);
    }
}
