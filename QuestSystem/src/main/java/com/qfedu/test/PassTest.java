package com.qfedu.test;

import com.qfedu.common.utils.MD5Utils;

public class PassTest {
    public static void main(String[] args) {
        String admin = MD5Utils.md5("admin");
        System.out.println(admin);
    }
}
