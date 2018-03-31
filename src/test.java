import twitter4j.TwitterException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class test {
    public static void main(String[] args) throws TwitterException, UnsupportedEncodingException, NoSuchAlgorithmException {
        Users.Users();
     //Users.userPostData("user01","Another test Message");
        Users.userGetData("user01");
    }
}
