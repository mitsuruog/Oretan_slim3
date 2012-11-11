package com.mitsuruog.gae.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class DateUtilTest extends DateUtil {



    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @DataPoints
    public static Fixture[] fixtures = {
        new Fixture("0000", false),
        new Fixture("0959", false),
        new Fixture("1000", true),
        new Fixture("2259", true),
        new Fixture("2300", true),
        new Fixture("2301", false),
        new Fixture("2359", false)
    };

    @Theory
    public void testIsActiveTime(Fixture fx) throws ParseException {

        SimpleDateFormat f = new SimpleDateFormat("HHmm");
        f.setLenient(true);

        Date start = f.parse("1000");
        Date end = f.parse("2300");

        assertThat(fx.param , isActiveTime(start, end, f.parse(fx.param)), is(fx.expected));

    }

    static class Fixture{
        String param;
        boolean expected;
        public Fixture(String param, boolean expected) {
            this.param = param;
            this.expected = expected;
        }
    }
}
