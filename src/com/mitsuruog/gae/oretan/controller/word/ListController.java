package com.mitsuruog.gae.oretan.controller.word;

import java.util.List;

import net.arnx.jsonic.JSON;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mitsuruog.gae.oretan.model.Word;
import com.mitsuruog.gae.oretan.service.WordService;
import com.mitsuruog.gae.util.Resp;

public class ListController extends Controller {

    private WordService service = new WordService();

    @Override
    public Navigation run() throws Exception {
        List<Word> words = service.getWords();

        String json = JSON.encode(words);
        Resp.responseJson(response, json);

        return null;
    }
}
