package com.mitsuruog.gae.oretan.controller.word;

import net.arnx.jsonic.JSON;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.mitsuruog.gae.oretan.model.Word;
import com.mitsuruog.gae.oretan.service.WordService;
import com.mitsuruog.gae.util.Auth;
import com.mitsuruog.gae.util.Resp;

public class PutController extends Controller {

    private WordService service = new WordService();

    @Override
    public Navigation run() throws Exception {

        if(Auth.isAuthenticated(request) == false) {
            return Resp.redirectLoginForm(request, response);
        }

        Word word = service.add(new RequestMap(request));
        String json = JSON.encode(word);
        Resp.responseJson(response, json);

        return null;

    }
}
