package com.mitsuruog.gae.oretan.controller.word;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.mitsuruog.gae.oretan.service.WordService;

public class PutController extends Controller {

    private WordService service = new WordService();

    @Override
    public Navigation run() throws Exception {

        service.add(new RequestMap(request));
        return redirect(basePath);
    }
}
