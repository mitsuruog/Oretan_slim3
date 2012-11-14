package com.mitsuruog.gae.oretan.controller.twitter;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

import com.mitsuruog.gae.oretan.model.Word;
import com.mitsuruog.gae.oretan.service.WordService;
import com.mitsuruog.gae.util.DateUtil;
import com.mitsuruog.gae.util.twitter.TwitterHelper;

public class IndexControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {

        //Stubs
        Word word = new Word();
        word.setEn("aaa");
        word.setJa("あああ");

        //TODO anyDate()的なことができない
        DateUtil d = mock(DateUtil.class);
        DateUtil dateUtil = spy(d);
        when(dateUtil.isActiveTime(isA(Date.class), isA(Date.class), isA(Date.class))).thenReturn(true);

        TwitterHelper twitterHelper = mock(TwitterHelper.class);
        doNothing().when(twitterHelper).tweet(anyString());

        WordService service = mock(WordService.class);
        when(service.getRundomSingle()).thenReturn(word);

        //Test
        tester.start("/twitter/");
        IndexController controller = tester.getController();

        verify(dateUtil).isActiveTime(isA(Date.class), isA(Date.class), isA(Date.class));
        verify(twitterHelper).tweet(anyString());
        verify(service).getRundomSingle();

        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/twitter/index.jsp"));
    }
}
