package edu.uc.crypt;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateTweetsforUsers {
    public static void main(String[] args) {
        TwitterInterface.initialize();
        generateTweets("user01");
        generateTweets("user02");
        generateTweets("user03");
        generateTweets("user04");
        generateTweets("user05");
        generateTweets("user06");
    }
    private static void generateTweets(String user){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        for (int i = 0; i < 4; i++) {
            Date date = new Date();
            String msg = "Post time is: "+dateFormat.format(date);
            TwitterInterface.postTweets(user,msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
