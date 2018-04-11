package edu.uc.crypt;

public class test {
    public static void main(String[] args) {
        TwitterInterface.initialize();
        TwitterInterface.getTweets("master");
    }
}
