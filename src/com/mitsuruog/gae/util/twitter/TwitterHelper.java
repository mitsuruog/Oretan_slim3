package com.mitsuruog.gae.util.twitter;

import java.util.Arrays;
import java.util.logging.Logger;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterHelper {

//	private final static String CONSUMER_KEY = Env.get("twitter.coustomerKey");
//	private final static String CONSUMER_SECRETY = Env.get("twitter.coustomerSecurity");
//	private final static String ACCESS_TOKEN = Env.get("twitter.accessToken");
//	private final static String ACCESS_TOKEN_SECRET = Env.get("twitter.accessTokenSecret");

    //TODO
    private final static String CONSUMER_KEY = "";
    private final static String CONSUMER_SECRETY = "";
    private final static String ACCESS_TOKEN = "";
    private final static String ACCESS_TOKEN_SECRET = "";

	private final static Logger LOGGER = Logger.getLogger(TwitterHelper.class.getName());

	private final static TwitterFactory FACTORY = new TwitterFactory();
	private static Twitter TWITTER = null;

	static{
		TWITTER = getTwitter();
	}

	private TwitterHelper() {}

	private static Twitter getTwitter(){
		Twitter twitter = FACTORY.getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRETY);
		twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET));
		return twitter;
	}

	/**
	 *
	 * @param message
	 * @throws TwitterException
	 */
	public static void tweet(String message) throws TwitterException{
		TWITTER.updateStatus(message);
		LOGGER.info("tweet:" + message);
	}

	/**
	 *
	 * @throws TwitterException
	 */
	public static void refollow() throws TwitterException {

		// フォローアカウント一覧を取得
		long[] friendIds = TWITTER.getFriendsIDs(1).getIDs();
		Arrays.sort(friendIds);

		LOGGER.info("follow count is " + friendIds.length);

		// フォローしていない人がいたらフォローする
		long[] followIds = TWITTER.getFollowersIDs(1).getIDs();
		for (long followId : followIds) {
			if (Arrays.binarySearch(friendIds, followId) < 0) {
				try{

					LOGGER.info("add follow:" + followId);
					TWITTER.createFriendship(followId);

				} catch (TwitterException e) {
					// フォローできないアカウントがいても警告を出して処理を続ける
					LOGGER.warning(e.toString());
				}
			}
		}
	}

	/**
	 *
	 * @throws TwitterException
	 */
	public static void unfollow() throws TwitterException {

		// フォロワーアカウント一覧を取得
		long[] followIds = TWITTER.getFollowersIDs(1).getIDs();
		Arrays.sort(followIds);

		LOGGER.info("follower count is " + followIds.length);

		// フォローしていない人がいたらフォローをはずす
		long[] friendIds = TWITTER.getFriendsIDs(1).getIDs();
		for (long friendId : friendIds) {
			if (Arrays.binarySearch(friendIds, friendId) < 0) {
				try {

					LOGGER.info("add friend:" + friendId);
					TWITTER.destroyFriendship(friendId);

				} catch (TwitterException e) {
					// フォロー外しできないアカウントがいても警告を出して処理を続ける
					LOGGER.warning(e.toString());
				}
			}
		}
	}

}
