import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Users {
    public static void user01Post(String postStatus) throws TwitterException {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey("q6UCGb7jPJ42UoL66stP49J5X")
                .setOAuthConsumerSecret("tBk1loZDY7gZJMky0AZn3dFgpm2pN5Xr7SD84fG4iAzDqcoOpC")
                .setOAuthAccessToken("979824715656318978-4cKvGeKwSoJO1jIc5DHygYDivsC0QEA")
                .setOAuthAccessTokenSecret("2UGYslqJJCu4bOHxG3GjW2EsQbk9XCGKmQQpk1jgY0RVN");
        TwitterFactory tf = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(postStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }

    public static void node01Post(String postStatus) throws TwitterException {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey("pBnsNT5D3UOfiL39yKAAXGsut")
                .setOAuthConsumerSecret("OnWJkbMogI9k3rMcuLU0QRBDfbUIxGbGYXCbUEaZVthAv2JZCs")
                .setOAuthAccessToken("979781226289647617-JaOIawxxYOBW6mz1mnbNbmpel6XnuvW")
                .setOAuthAccessTokenSecret("tmIBP0ewSdOp5PNUDLK79KcpbemMllR9QLQ81EbppF9wT");
        TwitterFactory tf = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(postStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
public static void node01Get() throws TwitterException {
    ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
    configurationBuilder.setDebugEnabled(true)
            .setOAuthConsumerKey("pBnsNT5D3UOfiL39yKAAXGsut")
            .setOAuthConsumerSecret("OnWJkbMogI9k3rMcuLU0QRBDfbUIxGbGYXCbUEaZVthAv2JZCs")
            .setOAuthAccessToken("979781226289647617-JaOIawxxYOBW6mz1mnbNbmpel6XnuvW")
            .setOAuthAccessTokenSecret("tmIBP0ewSdOp5PNUDLK79KcpbemMllR9QLQ81EbppF9wT");
    TwitterFactory tf = new TwitterFactory(configurationBuilder.build());
    Twitter twitter = tf.getInstance();
    List<Status> statuses = twitter.getHomeTimeline();
    System.out.println("Showing home timeline.");
    for (Status status : statuses) {
        System.out.println(status.getUser().getName() + ":" +
                status.getText());
    }
}

    public static void user01Get() throws TwitterException, UnsupportedEncodingException, NoSuchAlgorithmException {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey("q6UCGb7jPJ42UoL66stP49J5X")
                .setOAuthConsumerSecret("tBk1loZDY7gZJMky0AZn3dFgpm2pN5Xr7SD84fG4iAzDqcoOpC")
                .setOAuthAccessToken("979824715656318978-4cKvGeKwSoJO1jIc5DHygYDivsC0QEA")
                .setOAuthAccessTokenSecret("2UGYslqJJCu4bOHxG3GjW2EsQbk9XCGKmQQpk1jgY0RVN");
        TwitterFactory tf = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = tf.getInstance();
        List<Status> statuses = twitter.getHomeTimeline();
        for (Status status : statuses) {
            String msg[] = status.getText().split("\\r?\\n");
            System.out.println("Verification of message: "+msg[2]+": "+SignAndVerify.verifySign(msg[0],msg[1],msg[2]));
        }
    }
}
