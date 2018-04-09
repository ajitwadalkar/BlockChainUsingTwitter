package edu.uc.crypt;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Properties;

public class SignAndVerify {
    private static BigInteger primeNum =  new BigInteger("1374228530234763472016406730030809440720634793537908797");
    private static BigInteger gVal = new BigInteger("2");

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {


        String msg = "This is a test message";
        String password = "node01";
        String publicKey = getPubKey(password);
        System.out.println(publicKey);
        String signature =  signMsg(password,msg);
        System.out.println(verifySign(publicKey,signature,msg));
        String s =  publicKey +"\n"+signature+"\n"+msg;
        System.out.println(s);

    }

    public static String signMsg(String secretKey, String msg) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        BigInteger sk = getHash(secretKey);
        BigInteger hmsg = getHash(msg);
        BigInteger sign = gVal.modPow(hmsg.subtract(sk), primeNum); //g raised to (hash msg - secret key) mod p
        return DatatypeConverter.printHexBinary(sign.toByteArray());
    }

    public static String getPubKey(String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        BigInteger sk = getHash(secretKey);
        return DatatypeConverter.printHexBinary(gVal.modPow(sk, primeNum).toByteArray());
    }

    public static Boolean verifySign(String pubKey, String signature, String msg) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        BigInteger sign = new BigInteger(1, DatatypeConverter.parseHexBinary(signature));
        BigInteger pk = new BigInteger(1, DatatypeConverter.parseHexBinary(pubKey));
        BigInteger hmsg = getHash(msg);
        BigInteger gm = gVal.modPow(hmsg, primeNum);
        BigInteger sp = (sign.multiply(pk)).mod(primeNum);
        return gm.equals(sp);
    }
    public static BigInteger getHash(String msg) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bytesOfMessage = msg.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        BigInteger numHash = new BigInteger(1, thedigest);
        return  numHash;
    }


}
