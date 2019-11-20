package com.bin.yihai.common.test;

import com.bin.yihai.common.utils.EncryptUtil;

import java.util.Map;

/**
 * @program: Utopia
 * @description:
 * @author: Feri
 * @create: 2019-11-12 14:49
 */
public class PassKey_Main {
    public static void main(String[] args) {
        Map<String,String> map= EncryptUtil.createRSAKey();
        System.out.println(map.get(EncryptUtil.PUBKEY));
        System.out.println(map.get(EncryptUtil.PRIKEY));
        String m="123456";
        String mw= EncryptUtil.rsaEnc(map.get(EncryptUtil.PRIKEY),m);
        System.out.println("密文："+mw);
        System.out.println("明文："+EncryptUtil.rsaDec(map.get(EncryptUtil.PUBKEY),mw));
    }
}
