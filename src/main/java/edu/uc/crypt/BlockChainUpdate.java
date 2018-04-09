package edu.uc.crypt;

import twitter4j.TwitterFactory;

import java.util.HashMap;

public class BlockChainUpdate {
    public static void main(String[] args) {
        TwitterInterface.initialize();
        TwitterInterface.fetchTweets("master");
        HashMap<String, Integer> consensus = TwitterInterface.getConsensus();
        for(String s:consensus.keySet())
        {
            if(consensus.get(s)>=4)
            {
                TwitterInterface.postTweets("master",s);
            }
        }

    }
}
