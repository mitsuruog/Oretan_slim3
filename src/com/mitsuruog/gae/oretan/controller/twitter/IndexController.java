package com.mitsuruog.gae.oretan.controller.twitter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mitsuruog.gae.oretan.model.Word;
import com.mitsuruog.gae.oretan.service.WordService;
import com.mitsuruog.gae.util.DateUtil;
import com.mitsuruog.gae.util.twitter.TwitterHelper;

public class IndexController extends Controller {

    private WordService service = new WordService();
    private DateUtil dateUtil = new DateUtil();

    private static final Logger LOGGER = Logger.getLogger(IndexController.class.getName());

    @Override
    public Navigation run() throws Exception {

        //TODO 9:00-23:00
        String start = "0900";
        String end = "2300";

        //稼働時間判定
        SimpleDateFormat f = new SimpleDateFormat("HHmm");
        Date now = new Date();
        if(dateUtil.isActiveTime(f.parse(start), f.parse(end), now) == false){
            LOGGER.info("Now is not active time:" + f.format(now));
            return null;
        }

        Word word = service.getRundomSingle();
        if(word == null){
            LOGGER.warning("word is null value.");
        }
        TwitterHelper twitterHelper = new TwitterHelper();
        twitterHelper.tweet(word.getTweet());
        LOGGER.info("tweet message -> " + word.getTweet());

        return null;

    }
}
