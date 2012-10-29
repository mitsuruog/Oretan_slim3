package com.mitsuruog.gae.oretan.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;
import com.mitsuruog.gae.oretan.meta.WordMeta;
import com.mitsuruog.gae.oretan.model.Word;


public class WordService {

    private WordMeta w = new WordMeta();

    public Word add(Map<String, Object> input) {
        Word word = new Word();
        BeanUtil.copy(input, word);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(word);
        tx.commit();
        return word;
    }

    public List<Word> getWords() {
       return Datastore.query(w).sort(w.en.asc).asList();
    }

    public Word getRundomSingle(){
        //TODO Rundam Get
        return Datastore.query(w).asSingle();
    }

}
