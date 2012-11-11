package com.mitsuruog.gae.util;

import static com.mitsuruog.gae.test.util.LoginHelper.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class AuthTest extends ControllerTestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ログインしてない() {
        whenNotLogin(tester);
        assertThat(Auth.isAuthenticated(tester.request), is(false));
    }
    @Test
    public void Admin以外でログイン() {
        whenLoginBy(tester, "test@test.com", "test");
        assertThat(Auth.isAuthenticated(tester.request), is(false));
    }
    @Test
    public void Adminでログイン() {
        whenAdminLoginBy(tester, "admin@test.com", "admin");
        assertThat(Auth.isAuthenticated(tester.request), is(true));
    }

}
