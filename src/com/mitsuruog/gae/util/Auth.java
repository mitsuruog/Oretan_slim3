package com.mitsuruog.gae.util;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class Auth {

    public static boolean isAuthenticated(final HttpServletRequest req){

        UserService service = UserServiceFactory.getUserService();
        Principal principal = req.getUserPrincipal();

        return (principal == null ||
                service.getCurrentUser() == null ||
                service.isUserAdmin() == false) ? false : true;
    }
}
