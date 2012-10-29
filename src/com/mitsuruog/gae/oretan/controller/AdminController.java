package com.mitsuruog.gae.oretan.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class AdminController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("WEB-INF/admin.html");
    }
}
