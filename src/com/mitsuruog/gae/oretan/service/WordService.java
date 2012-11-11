package com.mitsuruog.gae.oretan.service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.mitsuruog.gae.oretan.meta.WordMeta;
import com.mitsuruog.gae.oretan.model.Word;


public class WordService {

    private WordMeta w = new WordMeta();

    /**
     * 1件登録
     * @param input
     * @return
     */
    public Word add(Map<String, Object> input) {
        Word word = new Word();
        BeanUtil.copy(input, word);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(word);
        tx.commit();
        return word;
    }

    /**
     * 全リストを取得
     * @return
     */
    public List<Word> getWords() {
       return Datastore.query(w).sort(w.en.asc).asList();
    }

    /**
     * ランダムで1件取得
     * @return
     */
    public Word getRundomSingle(){
        List<Key> keys = Datastore.query(w).asKeyList();
        Random random = new Random();
        return Datastore.get(w, keys.get(random.nextInt(keys.size())));
    }

    /**
     * 1件削除
     * @param input
     * @return
     */
    public Word deleteSingle(Map<String, Object> input){
        Word word = new Word();
        BeanUtil.copy(input, word);
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(word.getKey());
        tx.commit();
        return word;
    }

    /**
     * Keyで1件取得
     * @param key
     * @return
     */
    public Word getByKey(Key key) {
        return Datastore.query(w).filter(w.key.equal(key)).asSingle();
    }

}
