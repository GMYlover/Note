package com.supinfo.gmy.util.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/** 
* @Description: 获取字符的MD5值,可以用DigestUtils.md5Hex
* @author: gaomingyang
* @date: 2020-03-27
*/
public class Md5Util {

    /**
 　* @description: 用于获取一个String的md5值
 　* @author zhangjingye
 　* @date 2019/7/15 17:05
 　*/
    public static String getMd5(String plainText) {
        // 定义一个字节数组
        byte[] secretBytes = null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 对字符串进行加密
            md.update(plainText.getBytes());
            // 获得加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("md5算法异常");
        }
        // 将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = md5code.length(); i < 32 ; i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

}
