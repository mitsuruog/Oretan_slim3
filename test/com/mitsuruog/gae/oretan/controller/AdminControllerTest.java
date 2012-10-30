package com.mitsuruog.gae.oretan.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;


public class AdminControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin");
        AdminController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/WEB-INF/admin.html"));
    }
}
