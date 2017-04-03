package event;

import dao.TweetDao;
import model.Tweet;

/**
 * Created by Bramd on 29-3-2017.
 */
public class AddTweetEvent {

	private Tweet tweet;

	public Tweet getTweet() {
		return tweet;
	}

	public AddTweetEvent(Tweet tweet) {
		this.tweet = tweet;
	}
}
