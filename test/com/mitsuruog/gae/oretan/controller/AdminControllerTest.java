package com.mitsuruog.gae.oretan.controller;

import static com.mitsuruog.gae.test.util.LoginHelper.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class AdminControllerTest extends ControllerTestCase {

    @Override
    public void setUp() throws Exception {
         super.setUp();
    }

    @Test
    public void Admin() throws Exception {
        whenAdminLoginBy(tester, "admin@test.com", "admin");
        tester.start("/admin");
        AdminController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/WEB-INF/admin.html"));
    }
    @Test
    public void 一般() throws Exception {
        whenLoginBy(tester, "test@test.com", "tesr");
        tester.start("/admin");
        AdminController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/_ah/login?continue=%2Fadmin"));
    }
    @Test
    public void ログインしていない() throws Exception {
        whenNotLogin(tester);
        tester.start("/admin");
        AdminController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/_ah/login?continue=%2Fadmin"));
    }
}
