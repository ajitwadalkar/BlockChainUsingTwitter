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

public class Nodes {
    static ConfigurationBuilder node01ConfigBuilder = new ConfigurationBuilder();
    public static void Nodes(){
        node01ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("pBnsNT5D3UOfiL39yKAAXGsut")
                .setOAuthConsumerSecret("OnWJkbMogI9k3rMcuLU0QRBDfbUIxGbGYXCbUEaZVthAv2JZCs")
                .setOAuthAccessToken("979781226289647617-JaOIawxxYOBW6mz1mnbNbmpel6XnuvW")
                .setOAuthAccessTokenSecret("tmIBP0ewSdOp5PNUDLK79KcpbemMllR9QLQ81EbppF9wT");
    }

    public static void nodeGetData(String node) throws UnsupportedEncodingException, NoSuchAlgorithmException, TwitterException {
        TwitterFactory tf = null;
        switch(node)
        {
            case "node01":
                tf = new TwitterFactory(node01ConfigBuilder.build());
                break;
        }
        Twitter twitter = null;
        if (tf != null) {
            twitter = tf.getInstance();
            List<Status> statuses = twitter.getHomeTimeline();
            Properties prop = new Properties();
            InputStream input = null;
            try {
                input = new FileInputStream("/home/phoenix/IdeaProjects/BlockChainV_01/src/main/resources/edu/uc/crypt/data.properties");
                prop.load(input);
                input.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            long latestId = Long.parseLong(prop.getProperty("latestId"));//read from property file here
            for (Status status : statuses) {
                 long id = status.getId();
                 if(id < latestId){
                     continue;
                 }
                 latestId = id;
                String user = status.getUser().getName();
                String pubKey = SignAndVerify.getPubKey(user);
//                String msg[] = status.getText().split("\\r?\\n");
//                System.out.println("Verification of message: "+msg[1]+": "+SignAndVerify.verifySign(pubKey,msg[0],msg[1]));
            }
            OutputStream output = null;
            try {
                output = new FileOutputStream("/home/phoenix/IdeaProjects/BlockChainV_01/src/main/resources/edu/uc/crypt/data.properties");
                System.out.println(latestId);
                prop.setProperty("latestId",latestId+"");
                prop.store(output,null);
                output.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    public static void node01Post(String postStatus) throws TwitterException {
        TwitterFactory tf = new TwitterFactory(node01ConfigBuilder.build());
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(postStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
    public static void node01Get() throws TwitterException {
        TwitterFactory tf = new TwitterFactory(node01ConfigBuilder.build());
        Twitter twitter = tf.getInstance();
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }
}
