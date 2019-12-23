package com.peanut.jwt_learning.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Kenny Liu
 * @version 2019-12-23
 **/
public class MD5Util {

    public static String md5(String raw) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(raw.getBytes());
            byte[] digest = md5.digest();
            StringBuilder sb = new StringBuilder();
            byte[] var4 = digest;
            int var5 = digest.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                byte b = var4[var6];
                sb.append(String.format("%02x", b & 255));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException var8) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(md5("654321"));
    }
}
