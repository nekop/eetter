package jp.programmers.eetter;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheRemoveAll;
import javax.cache.annotation.CacheRemoveEntry;

import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Level.*;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@CacheDefaults(cacheName="twitter")
public class TwitterService {

    Logger log = Logger.getLogger("TwitterService");

    @CacheResult
    public List<Tweet> search(String queryString) throws TwitterException {
        //new Exception().printStackTrace();
        log.log(INFO, "Twitter search query={0}", queryString);
        Twitter twitter = new TwitterFactory().getInstance();
        Query query = new Query(queryString);
        QueryResult result = twitter.search(query);
        List<Tweet> tweets = result.getTweets();
        log.log(INFO, "{0} results found", tweets.size());
        return tweets;
    }

    @CacheRemoveEntry
    public void removeCache(String queryString) {
        // noop
    }

    @CacheRemoveAll
    public void clearCache() {
    }

}
