package com.mitsuruog.gae.util.twitter;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.mitsuruog.gae.util.Prop;

/**
 * Twitter関連クラス
 * @author mitsuruog
 *
 */
public class TwitterHelper {

    private final static String CONSUMER_KEY = "twitter.coustomerKey";
    private final static String CONSUMER_SECRETY = "twitter.coustomerSecurity";
    private final static String ACCESS_TOKEN = "twitter.accessToken";
    private final static String ACCESS_TOKEN_SECRET = "twitter.accessTokenSecret";

	private final static Logger LOGGER = Logger.getLogger(TwitterHelper.class.getName());
	private Twitter twitter = null;

	/**
	 * @throws IOException
	 *
	 */
	public TwitterHelper() throws IOException {
        Prop p = new Prop("src/keys.properties");
        twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer(p.get(CONSUMER_KEY), p.get(CONSUMER_SECRETY));
        twitter.setOAuthAccessToken(new AccessToken(p.get(ACCESS_TOKEN), p.get(ACCESS_TOKEN_SECRET)));
	}

	/**
	 * Tweetする
	 * @param message
	 * @throws TwitterException
	 */
	public void tweet(String message) throws TwitterException{
		twitter.updateStatus(message);
		LOGGER.info("tweet:" + message);
	}

	/**
	 * followされたユーザをfollowする
	 * @throws TwitterException
	 */
	public void refollow() throws TwitterException {

		// フォローアカウント一覧を取得
		long[] friendIds = twitter.getFriendsIDs(1).getIDs();
		Arrays.sort(friendIds);

		LOGGER.info("follow count is " + friendIds.length);

		// フォローしていない人がいたらフォローする
		long[] followIds = twitter.getFollowersIDs(1).getIDs();
		for (long followId : followIds) {
			if (Arrays.binarySearch(friendIds, followId) < 0) {
				try{

					LOGGER.info("add follow:" + followId);
					twitter.createFriendship(followId);

				} catch (TwitterException e) {
					// フォローできないアカウントがいても警告を出して処理を続ける
					LOGGER.warning(e.toString());
				}
			}
		}
	}

	/**
	 * followしたないユーザは、followからはずす
	 * @throws TwitterException
	 */
	public void unfollow() throws TwitterException {

		// フォロワーアカウント一覧を取得
		long[] followIds = twitter.getFollowersIDs(1).getIDs();
		Arrays.sort(followIds);

		LOGGER.info("follower count is " + followIds.length);

		// フォローしていない人がいたらフォローをはずす
		long[] friendIds = twitter.getFriendsIDs(1).getIDs();
		for (long friendId : friendIds) {
			if (Arrays.binarySearch(friendIds, friendId) < 0) {
				try {

					LOGGER.info("add friend:" + friendId);
					twitter.destroyFriendship(friendId);

				} catch (TwitterException e) {
					// フォロー外しできないアカウントがいても警告を出して処理を続ける
					LOGGER.warning(e.toString());
				}
			}
		}
	}

}
