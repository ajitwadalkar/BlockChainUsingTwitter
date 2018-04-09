package edu.uc.crypt;


public class ValidateTweets {
    public static void main(String[] args) {
    TwitterInterface.initialize();
    TwitterInterface.nodeGetData("node01");
    TwitterInterface.nodeGetData("node02");
    }
}
