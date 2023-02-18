package com.example.capstoneproject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void passWordisValid() {
        assertTrue(RegisterActivity.isValid("Enes123?"));
    }

    @Test
    public void passWordNotValid1(){
        assertFalse(RegisterActivity.isValid("enes"));
    }
    @Test
    public void passWordNotValid2(){
        assertFalse(RegisterActivity.isValid("Enes"));
    }
    @Test
    public void passWordNotValid3(){
        assertFalse(RegisterActivity.isValid("Enes1"));
    }
    @Test
    public void passWordNotValid4(){
        assertFalse(RegisterActivity.isValid("Enes12"));
    }
    @Test
    public void passWordNotValid5(){
        assertFalse(RegisterActivity.isValid("Enes123"));
    }
    @Test
    public void passWordNotValid6(){
        assertFalse(RegisterActivity.isValid("Enes1234"));
    }
}