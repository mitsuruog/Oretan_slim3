package com.mitsuruog.gae.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testProp() throws IOException {
        Prop p = new Prop("src/keys.properties");
        assertThat("ok", is(p.get("unittest")));
    }

}
