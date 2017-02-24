import tweepy

'''
//Consumer Key : <3iiwvPHx3JMHtG8IldATevUgA>
//Secret Key : <WjVrQLgwxGjMhU7Mq0baS0qSzZqYcdRPX0gpq6mYzmhChB6oFG>
//Access Token :<119032408-2YuZzfjvke2VMeyWYjrwEPeJ0kVP484dhI2ZW6u1>
//Access Secret Token : <mtjwGYUrOhlfQRRWFjsJgrwKmypeAo28GYYxAKCWUs2QP>
'''

auth = tweepy.OAuthHandler('3iiwvPHx3JMHtG8IldATevUgA', 'WjVrQLgwxGjMhU7Mq0baS0qSzZqYcdRPX0gpq6mYzmhChB6oFG')
auth.set_access_token('119032408-2YuZzfjvke2VMeyWYjrwEPeJ0kVP484dhI2ZW6u1','mtjwGYUrOhlfQRRWFjsJgrwKmypeAo28GYYxAKCWUs2QP' )

api = tweepy.API(auth)
print'----------------------'
print 'My home timeline tweets'
print'-----------------------'
public_tweets = api.home_timeline()
for tweet in public_tweets:
    print tweet.text

print '-------- -------------'
print "Another User Tweets"
print '-----------------------'
# Get the User object for twitter...
#user = api.get_user('yogi_yugendhar')
#print user.screen_name
#print user.friends()

for status in tweepy.Cursor(api.user_timeline, id="realdonaldtrump").items(10) :
    print api.get_user('realdonaldtrump').screen_name+' : '+status.text

results = api.search(q="Trump")
for result in results:
    print result.text

'''for tweet in tweepy.Cursor(api.search,
                           q="trump",
                           rpp=10,
                           result_type="recent",
                           include_entities=True,
                           lang="en").items():
        print tweet.created_at, tweet.text

'''
