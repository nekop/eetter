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

    /*
     * List.size() from EL doesn't work in some platforms, see:
     * https://issues.apache.org/bugzilla/show_bug.cgi?id=51544
     */
    public int getTweetsSize() {
        if (tweets == null) {
            return 0;
        }
        return tweets.size();
    }
}
