package com.mitsuruog.gae.oretan.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mitsuruog.gae.util.Auth;
import com.mitsuruog.gae.util.Resp;

public class AdminController extends Controller {

    @Override
    public Navigation run() throws Exception {

        if(Auth.isAuthenticated(request) == false) {
            return Resp.redirectLoginForm(request, response);
        }

        return forward("WEB-INF/admin.html");
    }
}
