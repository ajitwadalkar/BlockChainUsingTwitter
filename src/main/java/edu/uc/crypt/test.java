package edu.uc.crypt;

import twitter4j.TwitterException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class test {
    public static void main(String[] args) throws TwitterException, UnsupportedEncodingException, NoSuchAlgorithmException {
        Users.Users();
        Nodes.Nodes();
//        Users.userPostData("node01","Another test Message");
//        System.out.printf(System.getProperty("java.class.path"));
        Nodes.nodeGetData("node01");
    }
}