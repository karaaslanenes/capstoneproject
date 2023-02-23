package com.example.capstoneproject;

import org.junit.Test;

import static org.junit.Assert.*;

import android.os.Bundle;

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
    public void passWordValid2(){
        assertTrue(RegisterActivity.isValid("ALEx123?"));
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
    @Test
    public void get(){
       DoctorDetails doctorDetails=new DoctorDetails("ivan","dentist","7","43678567","250");

    }
}