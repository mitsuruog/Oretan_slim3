package com.mitsuruog.gae.oretan.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

public class WordTest extends AppEngineTestCase {

    private Word model = new Word();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
