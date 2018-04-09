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
public class TwitterInterface {
    //Users Config
    static ConfigurationBuilder user01ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder user02ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder user03ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder user04ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder user05ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder user06ConfigBuilder = new ConfigurationBuilder();

    //Nodes Config
    static ConfigurationBuilder node01ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder node02ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder node03ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder node04ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder node05ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder node06ConfigBuilder = new ConfigurationBuilder();
    static ConfigurationBuilder node07ConfigBuilder = new ConfigurationBuilder();

    //TweeterFactory
    static TwitterFactory tfUser01;
    static TwitterFactory tfUser02;
    static TwitterFactory tfUser03;
    static TwitterFactory tfUser04;
    static TwitterFactory tfUser05;
    static TwitterFactory tfUser06;

    public static void TwitterInterface(){
        user01ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("unACzlI4DYiEaqhCwolADw810")
                .setOAuthConsumerSecret("ruMdswNC3t3M5G9zxT0TjMo502NUBUwP5BsOXZ2jkHCroA0bs8")
                .setOAuthAccessToken("979779756597174273-ILxdR8WKzn3CiLlrmKJ1NJbULW6VrX6")
                .setOAuthAccessTokenSecret("3g9cUYGeaVF7CvLNkwGrU0fNQ7PPuLq5T8VMr0UokvtO4");

        user02ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("Rs36ZMPGsSJGyHlVFWzv0hPEo")
                .setOAuthConsumerSecret("VbSrHPt7RY1dG36N3NGIr8RrBzep1CqZ46x8QbESOmZLOevII9")
                .setOAuthAccessToken("981201937881288704-IO1fJoMRqmmaEAfgZQ1jnwAXITxlB3X")
                .setOAuthAccessTokenSecret("S9hyFHRlxEm1OASlu2O13HmmYtIQQS9xyzZr2pqbMsMwj");

        user03ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("bEGbD4ziWmbGpT0TizmpfmX6D")
                .setOAuthConsumerSecret("s73mTOu31hCENN7aSPATMRihYBhhT3GIyuZJqfDlNG757KW43P")
                .setOAuthAccessToken("981204400373948417-2bLvUeBa9s7j1NLHXoDb5zkhroNQ56N")
                .setOAuthAccessTokenSecret("eexWnlIBIvE1LHP1ftdALzGkdnHR48yHh14v8KxKRBsyB");

        user04ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("JNLdsmcqDYBiThnenqFD3vRpE")
                .setOAuthConsumerSecret("zLGbyWawwzNxTR9RQrXzaxwCgfdrxxPMrsRCi4S9kbmobekeIH")
                .setOAuthAccessToken("981213506237353985-71aUt2QbdXBrEIn7m786jWgZQNZkhla")
                .setOAuthAccessTokenSecret("a3j4jUrsmP1oF6XIONA83uNLyz8mxqZtLPJfOU14ZRH7O");

        user05ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("cp4QQj9HiCg9dn8YEfWACx2BX")
                .setOAuthConsumerSecret("XbAi2rCEIZayfoSxz33TzbMFbo6MCMjf8WnYzMn4wLJsPIsRAx")
                .setOAuthAccessToken("981217492780699648-vhkyP6l5a3jD4VYLk6wIVOBRunaYjtw")
                .setOAuthAccessTokenSecret("75LoqFXV6hl92GHE2EoEmPB98g6xY104Bq81sMwXPuhRb");

        user06ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("SeqDqIgx9ZGP5SKOaIHtTcVjR")
                .setOAuthConsumerSecret("ggg4T6L3fDEIqMxAr2h9NK0EmCZnffKuIxrmRHAJrE50zmsAHq")
                .setOAuthAccessToken("981223557500997633-3KwX049AQMLjVS44cGiAFTMFOLNJXVs")
                .setOAuthAccessTokenSecret("TshQviM2DwzMP9EjlsD5rI9HHQiMn3XaoLSH4JFDfN9eW");

        node01ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("pBnsNT5D3UOfiL39yKAAXGsut")
                .setOAuthConsumerSecret("OnWJkbMogI9k3rMcuLU0QRBDfbUIxGbGYXCbUEaZVthAv2JZCs")
                .setOAuthAccessToken("979781226289647617-JaOIawxxYOBW6mz1mnbNbmpel6XnuvW")
                .setOAuthAccessTokenSecret("tmIBP0ewSdOp5PNUDLK79KcpbemMllR9QLQ81EbppF9wT");

        node02ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("lxmaWtP2Ol5BYg7d32sInvphf")
                .setOAuthConsumerSecret("4HVenw32MH5RtLuE3rF0GJYJIt2FDvJ1VQl66DFuZjM5YdA4ej")
                .setOAuthAccessToken("981203196101177344-2osjbnYBfnNvhjSa6OkxBgGfBCn5kwt")
                .setOAuthAccessTokenSecret("YmnMVb98azpiZGHInhX3YU3GFnOfWIShiFdY4DlkMBzat");

        node03ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("XTexmRazuuEEeWwA7pUIl31MH")
                .setOAuthConsumerSecret("1qymJgoVCCcHqDvOdsCG81zxIDpXIfHezb4lWl7qJZYFmJ0Yqo")
                .setOAuthAccessToken("981208370035220480-SdZdz6Jg0ZB4tHkAyurrqbnKungfFqY")
                .setOAuthAccessTokenSecret("5fow18UlgH0GWUtAjAB7bS6qxk5TZKRgVAvvgLpViKChH");

        node04ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("iQohw249pAkiIumXFXjKOZgfT")
                .setOAuthConsumerSecret("J3vdGh6NaF3WAkBZjxIXZNql0Nn1uYdihYz9G3YhoO8uxk0tGv")
                .setOAuthAccessToken("981208370035220480-Q9fWjtUe4DJs4612eGXjXvPDLq4JHrC")
                .setOAuthAccessTokenSecret("ee8H0uQ36gcyBN5MUiVmhpEUFLUZM1KmwDrJ1ebg43UrN");

        node05ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("VSshGGOoFwsA9jnWdLabgeDAO")
                .setOAuthConsumerSecret("eiRaokjSxxtP6y6J7jcR83toDx7WtlMjw4yaHRsTu1D3ZADWa2")
                .setOAuthAccessToken("981222793693089792-oAyS5vPxz7BM8yApzOsEwUamtKnUmfj")
                .setOAuthAccessTokenSecret("yHzvycLLqYajGBk2pVcQOBYDpjWMp9Ud2Rab8lBk1IhEu");

        node06ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("9TxijDKBABO40y0kA1DncdD5F")
                .setOAuthConsumerSecret("p0MCJ7snlZ0xn4bTdDdp4TKHYGt4u56UQDVgHkptp0OJUlFW2U")
                .setOAuthAccessToken("981225014635696129-i2Z8I6j1K0c6cwaP9UhEvvaHqluN6Iy")
                .setOAuthAccessTokenSecret("8MkuFO4YJT1pgNAWplxzJ6aCa5tWRvg5WsX47p0w7kHcz");

        node07ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("kw9pD0gxQcAvkftkEDFSZddZj")
                .setOAuthConsumerSecret("YN6xuNyGHr9bMoFgndLKQpF5NZAs0lJ9rLzIVcJLufiQaceImt")
                .setOAuthAccessToken("981244873297801217-1IS8MhD4WiGf3HxdcdZUXIMx0KbuxBx")
                .setOAuthAccessTokenSecret("0lcvCIOuhBMcSKv6Z1QmSien9T1iPoqC4uHYXzMNRdYMh");

        buildTwitterFactory();
    }

    public static void buildTwitterFactory(){
        //TwitterFactory
        tfUser01 = new TwitterFactory(user01ConfigBuilder.build());
        tfUser02 = new TwitterFactory(user02ConfigBuilder.build());
        tfUser03 = new TwitterFactory(user03ConfigBuilder.build());
        tfUser04 = new TwitterFactory(user04ConfigBuilder.build());
        tfUser05 = new TwitterFactory(user05ConfigBuilder.build());
        tfUser06 = new TwitterFactory(user06ConfigBuilder.build());
    }

    public static void userPostData(String user, String msg){
        TwitterFactory tf = null;
        switch(user)
        {
            case "user01":
                tf = tfUser01;
                break;
            case "user02":
                tf = tfUser02;
                break;
            case "user03":
                tf = tfUser03;
                break;
            case "user04":
                tf = tfUser04;
                break;
            case "user05":
                tf = tfUser05;
                break;
            case "user06":
                tf = tfUser06;
                break;
        }
        Twitter twitter = null;
        if (tf != null) {
            twitter = tf.getInstance();
            try {
                twitter.updateStatus(SignAndVerify.signMsg(user,msg)+"\n"+msg);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            System.out.println("Tweet posted succesfully for "+user);
        }
    }

}
