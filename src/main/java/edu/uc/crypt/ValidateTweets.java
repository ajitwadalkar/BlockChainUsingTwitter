package edu.uc.crypt;


public class ValidateTweets {
    public static void main(String[] args) {
    TwitterInterface.initialize();
    TwitterInterface.fetchTweets("node01");
    TwitterInterface.fetchTweets("node02");
    TwitterInterface.fetchTweets("node03");
    TwitterInterface.fetchTweets("node04");
    TwitterInterface.fetchTweets("node05");
    TwitterInterface.fetchTweets("node06");
    TwitterInterface.fetchTweets("node07");
    }
}
