package edu.uc.crypt;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

class TwitterInterface {
    //Blockchain Master config
    private static ConfigurationBuilder masterConfigBuilder = new ConfigurationBuilder();

    //Users Config
    private static ConfigurationBuilder user01ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder user02ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder user03ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder user04ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder user05ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder user06ConfigBuilder = new ConfigurationBuilder();

    //Nodes Config
    private static ConfigurationBuilder node01ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder node02ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder node03ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder node04ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder node05ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder node06ConfigBuilder = new ConfigurationBuilder();
    private static ConfigurationBuilder node07ConfigBuilder = new ConfigurationBuilder();

    //TweeterFactory Master
    private static TwitterFactory tfmaster;

    //TweeterFactory users
    private static TwitterFactory tfUser01;
    private static TwitterFactory tfUser02;
    private static TwitterFactory tfUser03;
    private static TwitterFactory tfUser04;
    private static TwitterFactory tfUser05;
    private static TwitterFactory tfUser06;

    //TweeterFactory nodes
    private static TwitterFactory tfnode01;
    private static TwitterFactory tfnode02;
    private static TwitterFactory tfnode03;
    private static TwitterFactory tfnode04;
    private static TwitterFactory tfnode05;
    private static TwitterFactory tfnode06;
    private static TwitterFactory tfnode07;
    private static String dataPropPath;

    //HashMap to save blockchain tweets
    private static HashMap<String, Integer> consensus = new HashMap<>();

    static void initialize() {
        dataPropPath = ValidateTweets.class.getResource("data.properties").getPath();
        setTokens();
        buildTwitterFactory();
    }

    private static void setTokens() {
        //BlockChain Master Tokens
        masterConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("q6UCGb7jPJ42UoL66stP49J5X")
                .setOAuthConsumerSecret("tBk1loZDY7gZJMky0AZn3dFgpm2pN5Xr7SD84fG4iAzDqcoOpC")
                .setOAuthAccessToken("979824715656318978-4cKvGeKwSoJO1jIc5DHygYDivsC0QEA")
                .setOAuthAccessTokenSecret("2UGYslqJJCu4bOHxG3GjW2EsQbk9XCGKmQQpk1jgY0RVN");

        //User tokens
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

        //Node tokens
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

        node04ConfigBuilder.setDebugEnabled(true).setOAuthConsumerKey("cIv5xY4RtN7RpYWOKW5ORrHgj")
                .setOAuthConsumerSecret("UBxi6SrjMu69NDPmcwqBaa8Eoh7y03XjROYOFmjeWwNK7dMVhP")
                .setOAuthAccessToken("981216442212372481-MO2Ja7IH4DKlDZ21QVGiWIS8xT7WLyc")
                .setOAuthAccessTokenSecret("Fdj9aO5yB6P1d2OLFwgvoaRVcWdALKWsIoqmLgQgbnhPM");

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
    }

    private static void buildTwitterFactory() {
        //TwitterFactory
        tfmaster = new TwitterFactory(masterConfigBuilder.build());
        tfUser01 = new TwitterFactory(user01ConfigBuilder.build());
        tfUser02 = new TwitterFactory(user02ConfigBuilder.build());
        tfUser03 = new TwitterFactory(user03ConfigBuilder.build());
        tfUser04 = new TwitterFactory(user04ConfigBuilder.build());
        tfUser05 = new TwitterFactory(user05ConfigBuilder.build());
        tfUser06 = new TwitterFactory(user06ConfigBuilder.build());
        tfnode01 = new TwitterFactory(node01ConfigBuilder.build());
        tfnode02 = new TwitterFactory(node02ConfigBuilder.build());
        tfnode03 = new TwitterFactory(node03ConfigBuilder.build());
        tfnode04 = new TwitterFactory(node04ConfigBuilder.build());
        tfnode05 = new TwitterFactory(node05ConfigBuilder.build());
        tfnode06 = new TwitterFactory(node06ConfigBuilder.build());
        tfnode07 = new TwitterFactory(node07ConfigBuilder.build());

    }

    private static TwitterFactory getTFname(String name) {
        TwitterFactory tf = null;
        switch (name) {
            case "node01":
                tf = tfnode01;
                break;
            case "node02":
                tf = tfnode02;
                break;
            case "node03":
                tf = tfnode03;
                break;
            case "node04":
                tf = tfnode04;
                break;
            case "node05":
                tf = tfnode05;
                break;
            case "node06":
                tf = tfnode06;
                break;
            case "node07":
                tf = tfnode07;
                break;
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
            case "master":
                tf = tfmaster;
                break;
        }
        return tf;
    }

    static void postTweets(String user, String msg) {
        TwitterFactory tf = getTFname(user);
        Twitter twitter;
        if (tf != null) {
            twitter = tf.getInstance();
            try {
                if (user.equals("master")) {
                    twitter.updateStatus(msg);
                } else {
                    twitter.updateStatus(SignAndVerify.signMsg(user, msg) + "\n" + msg);
                }
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            System.out.println("Tweet posted succesfully for " + user);
        }
    }

    private static void nodePostData(String user, String msg) {
        TwitterFactory tf = getTFname(user);
        Twitter twitter;
        if (tf != null) {
            twitter = tf.getInstance();
            try {
                twitter.updateStatus(msg);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            System.out.println("Tweet posted succesfully for " + user);
        }
    }

    static void fetchTweets(String user) {

        TwitterFactory tf = getTFname(user);
        Twitter twitter;
        if (tf != null) {
            twitter = tf.getInstance();
            List<Status> statuses = null;
            long latestId = 0;

            try {
                Paging p = new Paging(1, 150);
                statuses = twitter.getHomeTimeline(p);
            } catch (TwitterException e) {
                e.printStackTrace();
            }

            Properties prop = new Properties();
            InputStream input;
            try {
                System.out.println(dataPropPath);
                input = new FileInputStream(dataPropPath);
                prop.load(input);
                input.close();
                if (user == "master") {
                    latestId = Long.parseLong(prop.getProperty("masterId"));
                } else {
                    latestId = Long.parseLong(prop.getProperty(user+"latestId"));
                }
                System.out.println(latestId);




            } catch (IOException e) {
                e.printStackTrace();
            }
            if (statuses != null) {
                long id = 0;
                long temp = 0;
                for (Status status : statuses) {
                    id = status.getId();
                    if (id < latestId) {
                        continue;
                    }
                    if(id > temp)
                        temp = id;
                    if (user.equals("master")) {
                        nodeTweetsConsensus(status);

                    } else {
                        String tweetUser = status.getUser().getName();
                        String pubKey = SignAndVerify.getPubKey(tweetUser);
                        String msg[] = status.getText().split("\\r?\\n");

//                        if (msg.length > 1 && SignAndVerify.verifySign(pubKey, msg[0], msg[1])) nodePostData(user, msg[1]);
                    }
                }
                if(temp > latestId)
                    latestId = temp;
            }
            OutputStream output;
            try {
                output = new FileOutputStream(dataPropPath);
                if (user == "master") {
                    prop.setProperty("masterId", latestId + "");
                } else {
                    prop.setProperty(user+"latestId", latestId + "");
                }
                System.out.println(dataPropPath);
                prop.store(output, null);
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void nodeTweetsConsensus(Status status) {
        if (consensus.containsKey(status.getText())) {
            consensus.put(status.getText(), (consensus.get(status.getText()) + 1));
        } else {
            consensus.put(status.getText(), 1);
        }
    }

    static HashMap<String, Integer> getConsensus() {
        return consensus;
    }


    static void getTweets(String user) {
        TwitterFactory tf = getTFname(user);

        Twitter twitter;
        if (tf != null) {
            twitter = tf.getInstance();
            List<Status> statuses = null;
            long latestId = 0;

            try {
                Paging p = new Paging(1, 150);
                statuses = twitter.getHomeTimeline(p);
            }  catch(NullPointerException e)
            {
                System.out.print("NullPointerException caught");
            }
            catch (TwitterException e) {
                e.printStackTrace();
            }
            if (statuses != null) {
                for (Status status : statuses) {
                        String tweetUser = status.getUser().getName();
                        String tweet = status.getText();
                    System.out.println(tweetUser+": "+tweet);
                    }
                }
                else
            {
                System.out.println("No statuses for "+user);
            }

        } else
        {
            System.out.println("No statuses for "+user);
        }

    }


}

