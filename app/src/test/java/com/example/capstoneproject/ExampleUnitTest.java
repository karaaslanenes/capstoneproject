package com.example.capstoneproject;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import android.os.Bundle;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    DoctorDetails doctorDetails=new DoctorDetails("ivan","dentist","7","43678567","250");
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
    public void getName(){
      // DoctorDetails doctorDetails=new DoctorDetails("ivan","dentist","7","43678567","250");
      String actualName=doctorDetails.getDoctor_name();
      String expectedName="ivan";
        Assert.assertEquals(expectedName,actualName);
    }
    @Test
    public void getSpecialty(){
        // DoctorDetails doctorDetails=new DoctorDetails("ivan","dentist","7","43678567","250");
        String actualSpec=doctorDetails.getDoctor_speciality();
        String expectedSpec="dentist";
        Assert.assertEquals(expectedSpec,actualSpec);
    }

    @Test
    public void getExperince(){
        // DoctorDetails doctorDetails=new DoctorDetails("ivan","dentist","7","43678567","250");
        String actualExp=doctorDetails.getDoctor_experiences();
        String expectedExp="7";
        Assert.assertEquals(expectedExp,actualExp);
    }

    @Test
    public void getPhone(){
        // DoctorDetails doctorDetails=new DoctorDetails("ivan","dentist","7","43678567","250");
        String actualPhn=doctorDetails.getDoctor_phone();
        String expectedPhn="43678567";
        Assert.assertEquals(expectedPhn,actualPhn);
    }
    @Test
    public void getPrice(){
        // DoctorDetails doctorDetails=new DoctorDetails("ivan","dentist","7","43678567","250");
        String actualPrx=doctorDetails.getConsultant_fee();
        String expectedPrx="250";
        Assert.assertEquals(expectedPrx,actualPrx);
    }
}