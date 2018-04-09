package edu.uc.crypt;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Properties;

public class Users {
    static ConfigurationBuilder user01ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder node01ConfigBuilder = new ConfigurationBuilder();

    public static void Users(){
        user01ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("unACzlI4DYiEaqhCwolADw810")
                .setOAuthConsumerSecret("ruMdswNC3t3M5G9zxT0TjMo502NUBUwP5BsOXZ2jkHCroA0bs8")
                .setOAuthAccessToken("979779756597174273-ILxdR8WKzn3CiLlrmKJ1NJbULW6VrX6")
                .setOAuthAccessTokenSecret("3g9cUYGeaVF7CvLNkwGrU0fNQ7PPuLq5T8VMr0UokvtO4");
        node01ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("pBnsNT5D3UOfiL39yKAAXGsut")
                .setOAuthConsumerSecret("OnWJkbMogI9k3rMcuLU0QRBDfbUIxGbGYXCbUEaZVthAv2JZCs")
                .setOAuthAccessToken("979781226289647617-JaOIawxxYOBW6mz1mnbNbmpel6XnuvW")
                .setOAuthAccessTokenSecret("tmIBP0ewSdOp5PNUDLK79KcpbemMllR9QLQ81EbppF9wT");
    }

    public static void userPostData(String user, String msg) throws UnsupportedEncodingException, NoSuchAlgorithmException, TwitterException {
          TwitterFactory tf = null;
          switch(user)
          {
              case "user01":
                  tf = new TwitterFactory(user01ConfigBuilder.build());
                  break;
              case "node01":
                  tf = new TwitterFactory(node01ConfigBuilder.build());
                  break;
          }
        Twitter twitter = null;
        if (tf != null) {
            twitter = tf.getInstance();
            twitter.updateStatus(SignAndVerify.signMsg(user,msg)+"\n"+msg);
            System.out.println("Message posted succesfully for "+user);
        }
    }

    public static void userGetData(String user) throws UnsupportedEncodingException, NoSuchAlgorithmException, TwitterException {
        TwitterFactory tf = null;
        String pubKey = SignAndVerify.getPubKey(user);
        switch(user)
        {
            case "user01":
                tf = new TwitterFactory(user01ConfigBuilder.build());
                break;
            case "node01":
                tf = new TwitterFactory(node01ConfigBuilder.build());
                pubKey = "00C281C99BB6B0B696316E0557720A5CDE43495D93F144";
                break;

        }
        Twitter twitter = null;
        if (tf != null) {
            twitter = tf.getInstance();
            List<Status> statuses = twitter.getHomeTimeline();

            for (Status status : statuses) {
                String msg[] = status.getText().split("\\r?\\n");
                System.out.println("Verification of message: "+msg[1]+": "+SignAndVerify.verifySign(pubKey,msg[0],msg[1]));
            }
        //Store in property here


        }
    }

}
