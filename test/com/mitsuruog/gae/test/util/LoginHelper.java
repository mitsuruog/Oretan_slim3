package com.mitsuruog.gae.test.util;

import org.slim3.tester.ControllerTester;

public class LoginHelper {

    private static final String KEY_USER_ID = "com.google.appengine.api.users.UserService.user_id_key";

    public static void whenNotLogin(ControllerTester tester) {
        tester.environment.setEmail(null);
        tester.environment.getAttributes().remove(KEY_USER_ID);
    }

    public static void whenAdminLoginBy(ControllerTester tester, String email, String userId) {
        tester.environment.setEmail(email);
        tester.environment.setAdmin(true);
        tester.environment.getAttributes().put(KEY_USER_ID, userId);
    }

    public static void whenLoginBy(ControllerTester tester, String email, String userId) {
        tester.environment.setEmail(email);
        tester.environment.setAdmin(false);
        tester.environment.getAttributes().put(KEY_USER_ID, userId);
    }

}
