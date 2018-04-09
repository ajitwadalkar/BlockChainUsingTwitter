package edu.uc.crypt;


public class ValidateTweets {
    public static void main(String[] args) {
    TwitterInterface.initialize();
    TwitterInterface.fetchTweets("node01");
    TwitterInterface.fetchTweets("node02");
    }
}
