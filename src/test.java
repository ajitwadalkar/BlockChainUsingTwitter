import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

public class test {
    public static void main(String[] args) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus("Hello, UC Test Node");
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
/*
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }*/
    }
}
