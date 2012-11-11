package com.mitsuruog.gae.test.util.matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnyDateTest extends AnyDate{

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void assertThatのテスト() {
        assertThat(new Date(), anyDate());
    }

    @Test
    public void testMatches() {
        assertThat(true, is(matches(new Date())));
        assertThat(false, is(matches("sssss")));
        assertThat(false, is(matches(true)));
        assertThat(false, is(matches(new Object())));
        assertThat(false, is(matches(1)));
        assertThat(false, is(matches(1.00d)));
    }
}
