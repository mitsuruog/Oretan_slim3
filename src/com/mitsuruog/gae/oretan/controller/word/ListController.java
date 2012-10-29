package com.mitsuruog.gae.oretan.controller.word;

import java.util.List;

import net.arnx.jsonic.JSON;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mitsuruog.gae.oretan.model.Word;
import com.mitsuruog.gae.oretan.service.WordService;

public class ListController extends Controller {

    private WordService service = new WordService();

    @Override
    public Navigation run() throws Exception {
        List<Word> words = service.getWords();

        String json = JSON.encode(words);

        //TODO Slim3のjson周りが直ったら置き換えるかも
        //String json = WordMeta.get().modelsToJson(words);

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        response.setStatus(200);
        response.getWriter().print(json);

        return null;
    }
}
