package edu.uc.crypt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class test {
    public static void main(String[] args) {

       TwitterInterface.initialize();
        TwitterInterface.getTweets("node02");
    }
}
