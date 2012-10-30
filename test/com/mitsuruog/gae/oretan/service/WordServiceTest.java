package com.mitsuruog.gae.oretan.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.mitsuruog.gae.oretan.model.Word;

public class WordServiceTest extends AppEngineTestCase {

    private WordService service = new WordService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
    @Test
    public void 単語を1件登録() throws Exception {

        Map<String, Object> word = new HashMap<String, Object>();

        Word worded = service.add(word);

        assertThat(worded, is(notNullValue()));

        Word stored = Datastore.get(Word.class, worded.getKey());

        assertThat(stored.getEn(), is(worded.getEn()));
        assertThat(stored.getJa(), is(worded.getJa()));

    }
    @Test
    public void 単語リストを取得() throws Exception {
        Word word = new Word();
        word.setEn("Hello");
        word.setJa("こんにちわ");
        Datastore.put(word);

        List<Word> words = service.getWords();

        assertThat(words.size(), is(1));
        assertThat(words.get(0).getEn(), is(word.getEn()));
        assertThat(words.get(0).getJa(), is(word.getJa()));

    }

    @Test
    public void ランガムで1件取得() throws Exception{

        Word word = new Word();
        word.setEn("Hello1");
        word.setJa("こんにちわ1");
        Datastore.put(word);

        word.setEn("Hello2");
        word.setJa("こんにちわ2");
        Datastore.put(word);

        word.setEn("Hello3");
        word.setJa("こんにちわ3");
        Datastore.put(word);

        Word rundom = service.getRundomSingle();

        assertThat(rundom, is(notNullValue()));

        //TODO Rundam Test

    }

    @Test
    public void 削除1件() throws Exception{

        Map<String, Object> word = new HashMap<String, Object>();
        Word worded = service.add(word);

        assertThat(worded, is(notNullValue()));

        word.put("key", worded.getKey());
        Word deleted = service.deleteSingle(word);

        assertThat(deleted, is(notNullValue()));

        Word selected = service.getByKey(worded.getKey());

        assertThat(selected, is(nullValue()));

    }
    @Test
    public void Keyで1件() throws Exception{

        Map<String, Object> word = new HashMap<String, Object>();
        Word worded = service.add(word);

        assertThat(worded, is(notNullValue()));

        Word selected = service.getByKey(worded.getKey());

        assertThat(selected, is(notNullValue()));
        assertThat(selected, is(worded));

    }

}
