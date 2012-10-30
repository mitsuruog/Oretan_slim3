package com.mitsuruog.gae.oretan.controller.word;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PutControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/word/put");
        PutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/word/put.jsp"));
    }
}
