
import java.util.List;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class ExploreTwitter4j
{
//Consumer Key : 3iiwvPHx3JMHtG8IldATevUgA 
//Secret Key : WjVrQLgwxGjMhU7Mq0baS0qSzZqYcdRPX0gpq6mYzmhChB6oFG
//Access Token :119032408-2YuZzfjvke2VMeyWYjrwEPeJ0kVP484dhI2ZW6u1
//Access Secret Token : mtjwGYUrOhlfQRRWFjsJgrwKmypeAo28GYYxAKCWUs2QP

public static void main(String[] args) throws TwitterException
{
	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true)
	  .setOAuthConsumerKey("3iiwvPHx3JMHtG8IldATevUgA")
	  .setOAuthConsumerSecret("WjVrQLgwxGjMhU7Mq0baS0qSzZqYcdRPX0gpq6mYzmhChB6oFG")
	  .setOAuthAccessToken("119032408-2YuZzfjvke2VMeyWYjrwEPeJ0kVP484dhI2ZW6u1")
	  .setOAuthAccessTokenSecret("mtjwGYUrOhlfQRRWFjsJgrwKmypeAo28GYYxAKCWUs2QP");
	TwitterFactory tf = new TwitterFactory(cb.build());
	Twitter twitter = tf.getInstance();
	List<Status> statuses = twitter.getHomeTimeline();
    System.out.println("---Showing my home timeline----");
    for (Status status : statuses) {
        System.out.println(status.getUser().getName() + ":" +
                          status.getText());
    }

    
    //Other User Time line data
    System.out.println("---Other user timeline data----");
    Paging pages= new Paging(1,40);
    statuses = twitter.getUserTimeline("realdonaldtrump",pages);
    for (Status status : statuses) {
        System.out.println(status.getUser().getName() + ":" +
                           status.getText());
     }
    
    Query query = new Query("source:twitter4j realdonaldtrump");
    QueryResult result = twitter.search(query);
    for (Status status : result.getTweets()) {
        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
    }
    
    System.out.println("---Key Word Search----");
    //Get tweets related to keyword
    query = new Query("trump");

    QueryResult qr = twitter.search(query);
    //List<Tweet> qrTweets = qr.getTweets();
    for (Status status : qr.getTweets()) {
        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
    }
    
}	
}
