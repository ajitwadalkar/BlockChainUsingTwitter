package edu.uc.crypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlockChainUpdate {
    public static void main(String[] args) {
        TwitterInterface.initialize();
        TwitterInterface.fetchTweets("master");
        HashMap<String, Integer> consensus = TwitterInterface.getConsensus();
        List<String> tweetsToPost=new ArrayList<String>();
        for(String s:consensus.keySet())
        {
            if(consensus.get(s)>=4)
            {
                tweetsToPost.add(s);
            }
        }

        int count = tweetsToPost.size();
        int loopCounter=0;
        String tweet="";
        for (int i = 0; i < count ; i++) {
            tweet = tweetsToPost.get(i)+"\n"+tweet;
            loopCounter=loopCounter+1;
            if(loopCounter==10)
            {
                loopCounter=0;
                TwitterInterface.postTweets("master",tweet);
                System.out.println("Block:");
                System.out.println(tweet);
                System.out.println();
                tweet ="";
                continue;
            }
        }
        System.out.println("Block:");
        System.out.println(tweet);
        TwitterInterface.postTweets("master",tweet);

    }
}
