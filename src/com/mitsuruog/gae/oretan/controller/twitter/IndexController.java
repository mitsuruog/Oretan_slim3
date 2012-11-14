package com.mitsuruog.gae.oretan.controller.twitter;

import java.io.IOException;
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
    private TwitterHelper twitterHelper = null;

    private static final Logger LOGGER = Logger.getLogger(IndexController.class.getName());

    public IndexController() throws IOException {
        twitterHelper = new TwitterHelper();
    }

    @Override
    public Navigation run() throws Exception {

        //TODO 9:00-23:00
//        String start = "0900";
//        String end = "2300";
//
//        String pattern = "HHmm";
//        DateConverter dc = new DateConverter(pattern);
//
//        //稼働時間判定
//        Date now = new Date();
//        if(dateUtil.isActiveTime(dc.getAsObject(start), dc.getAsObject(end), dateUtil.getJSTDate(now)) == false){
//            LOGGER.info("Now is not active time:" + dateUtil.getJSTDate(now, pattern));
//            return null;
//        }

        Word word = service.getRundomSingle();
        if(word == null){
            LOGGER.warning("word is null value.");
            return null;
        }

        twitterHelper.tweet(word.getTweet());
        LOGGER.info("tweet message -> " + word.getTweet());

        return null;

    }

}
