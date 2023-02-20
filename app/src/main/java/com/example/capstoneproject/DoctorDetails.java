package com.example.capstoneproject;

public class DoctorDetails {

    private String doctor_name;
    private String doctor_speciality;
    private String doctor_experiences;
    private String doctor_phone;
    private String consultant_fee;

    public DoctorDetails() {

    this.doctor_name="";
    this.doctor_speciality="";
    this.doctor_experiences="";
    this.doctor_phone="";
    this.consultant_fee="";
    }

    public DoctorDetails(String doctor_name, String doctor_speciality, String doctor_experiences, String doctor_phone, String consultant_fee) {
        this.doctor_name = doctor_name;
        this.doctor_speciality = doctor_speciality;
        this.doctor_experiences = doctor_experiences;
        this.doctor_phone = doctor_phone;
        this.consultant_fee = consultant_fee;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_speciality() {
        return doctor_speciality;
    }

    public void setDoctor_speciality(String doctor_speciality) {
        this.doctor_speciality = doctor_speciality;
    }

    public String getDoctor_experiences() {
        return doctor_experiences;
    }

    public void setDoctor_experiences(String doctor_experiences) {
        this.doctor_experiences = doctor_experiences;
    }

    public String getDoctor_phone() {
        return doctor_phone;
    }

    public void setDoctor_phone(String doctor_phone) {
        this.doctor_phone = doctor_phone;
    }

    public String getConsultant_fee() {
        return consultant_fee;
    }

    public void setConsultant_fee(String consultant_fee) {
        this.consultant_fee = consultant_fee;
    }

    @Override
    public String toString() {
        return "DoctorDetails{" +
                "doctor_name='" + doctor_name + '\'' +
                ", doctor_speciality='" + doctor_speciality + '\'' +
                ", doctor_experiences='" + doctor_experiences + '\'' +
                ", doctor_phone='" + doctor_phone + '\'' +
                ", consultant_fee='" + consultant_fee + '\'' +
                '}';
    }
}
