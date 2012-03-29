package jp.programmers.eetter;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import twitter4j.Tweet;

@Named
@RequestScoped
public class Eetter {

    @Inject
    private TwitterService twitter;
    private String query;
    private List<Tweet> tweets;
    
    public String getQuery() {
        return query;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    
    public List<Tweet> getTweets() {
        return tweets;
    }
    
    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
    
    public void search() throws Exception {
        tweets = twitter.search(query);
    }
}
