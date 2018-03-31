import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Users {
    static ConfigurationBuilder user01ConfigBuilder = new ConfigurationBuilder();
      public static void Users(){
        user01ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("q6UCGb7jPJ42UoL66stP49J5X")
                .setOAuthConsumerSecret("tBk1loZDY7gZJMky0AZn3dFgpm2pN5Xr7SD84fG4iAzDqcoOpC")
                .setOAuthAccessToken("979824715656318978-4cKvGeKwSoJO1jIc5DHygYDivsC0QEA")
                .setOAuthAccessTokenSecret("2UGYslqJJCu4bOHxG3GjW2EsQbk9XCGKmQQpk1jgY0RVN");
    }

    public static void userPostData(String user, String msg) throws UnsupportedEncodingException, NoSuchAlgorithmException, TwitterException {
          TwitterFactory tf = null;
          switch(user)
          {
              case "user01":
                  tf = new TwitterFactory(user01ConfigBuilder.build());
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
        String pubKey = "";
        switch(user)
        {
            case "user01":
                tf = new TwitterFactory(user01ConfigBuilder.build());
                pubKey = "046794F247C7D059582978BD02310243146F1D33F5E093";
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
        }
    }

}
