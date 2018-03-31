import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Nodes {
    static ConfigurationBuilder node01ConfigBuilder = new ConfigurationBuilder();
    public static void Nodes(){
        node01ConfigBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey("pBnsNT5D3UOfiL39yKAAXGsut")
                .setOAuthConsumerSecret("OnWJkbMogI9k3rMcuLU0QRBDfbUIxGbGYXCbUEaZVthAv2JZCs")
                .setOAuthAccessToken("979781226289647617-JaOIawxxYOBW6mz1mnbNbmpel6XnuvW")
                .setOAuthAccessTokenSecret("tmIBP0ewSdOp5PNUDLK79KcpbemMllR9QLQ81EbppF9wT");
    }

    public static void nodeGetData(String node, String msg) throws UnsupportedEncodingException, NoSuchAlgorithmException, TwitterException {
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
             for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" +
                        status.getText());
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
