package com.mitsuruog.gae.util.twitter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.TwitterException;

@SuppressWarnings("serial")
public class RefollowServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(RefollowServlet.class
			.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		LOGGER.info("★Start!!");
		TwitterHelper twitterHelper = new TwitterHelper();
		try {
		    twitterHelper.refollow();
		} catch (TwitterException e) {
			throw new ServletException(e);
		}
		LOGGER.info("★Finish!!");

	}

}
