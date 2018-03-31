import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SignAndVerify {
    private static BigInteger primeNum =  new BigInteger("1374228530234763472016406730030809440720634793537908797");
    private static BigInteger gVal = new BigInteger("2");

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {


        String msg = "This is a test message";
        String password = "user01";
        String[] keys;
        keys = getKeys(password);
        String secretKey = keys[0];
        String publicKey = keys[1];
        String signature =  signMsg(secretKey,msg);
        System.out.println(verifySign(publicKey,signature,msg));
        System.out.println(publicKey);
        System.out.println(signature);
        System.out.println(msg);


    }

    public static String signMsg(String secretKey, String msg) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        BigInteger sk = new BigInteger(1, DatatypeConverter.parseHexBinary(secretKey));
        BigInteger hmsg = getHash(msg);
        BigInteger sign = gVal.modPow(hmsg.subtract(sk), primeNum); //g raised to (hash msg - secret key) mod p
        return DatatypeConverter.printHexBinary(sign.toByteArray());
    }

    public static String[] getKeys(String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        BigInteger sk = getHash(secretKey);
        String[] keys = new String[2];
        keys[0] = DatatypeConverter.printHexBinary(sk.toByteArray());
        keys[1] = DatatypeConverter.printHexBinary(gVal.modPow(sk, primeNum).toByteArray());
        return keys;
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
