package com.mitsuruog.gae.oretan.controller.word;

import net.arnx.jsonic.JSON;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Errors;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.mitsuruog.gae.oretan.meta.WordMeta;
import com.mitsuruog.gae.oretan.model.Word;
import com.mitsuruog.gae.oretan.service.WordService;
import com.mitsuruog.gae.util.Auth;
import com.mitsuruog.gae.util.Resp;

public class PutController extends Controller {

    private WordService service = new WordService();
    private WordMeta m = WordMeta.get();

    @Override
    public Navigation run() throws Exception {

        if(Auth.isAuthenticated(request) == false) {
            return Resp.redirectLoginForm(request, response);
        }

        Validators v = new Validators(request);
        v.add(m.en, v.required(), v.maxlength(140));
        v.add(m.ja, v.required(), v.maxlength(140));
        if(!v.validate()){
            Errors errors = v.getErrors();
            String json = JSON.encode(errors);
            Resp.responseErrorJson(response, json);
            return null;
        }

        Word word = service.add(new RequestMap(request));
        String json = JSON.encode(word);
        Resp.responseJson(response, json);

        return null;

    }
}
