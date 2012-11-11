package com.mitsuruog.gae.test.util.matcher;

import java.util.Date;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * TODO mocitoで使おうと思ったけどisA()で代用できたっぽい
 * @author mitsuruog
 *
 */
public class AnyDate extends BaseMatcher<Date> {

    Object actual;

    public static Matcher<Date> anyDate(){
        return new AnyDate();
    }

    AnyDate() {
        // 引数とかもらう場合はここでthisとかにセット
    }

    public boolean matches(Object actual) {
        this.actual = actual;
        return (actual instanceof Date) ? true : false;
    }

    public void describeTo(Description desc) {
        desc.appendValue(this.actual.toString());
        desc.appendText(" is not Date");
    }

}
