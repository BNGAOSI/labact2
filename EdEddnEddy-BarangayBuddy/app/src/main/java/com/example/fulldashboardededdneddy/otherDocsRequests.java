package com.example.fulldashboardededdneddy;

import java.util.Map;

public class otherDocsRequests {
    String fullName, age, dateOfBirth, civilStatus, gender, address, purpose, documentType;
    String status;
public String userTokenOtherDocs;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public otherDocsRequests(String status) {
        this.status = status;
    }

    Map time;

    public otherDocsRequests() {
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public otherDocsRequests(String fullName, String age, String dateOfBirth, String civilStatus, String gender, String address, String purpose, String documentType, Map time, String userTokenOtherDocs) {
        this.fullName = fullName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.civilStatus = civilStatus;
        this.gender = gender;
        this.address = address;
        this.purpose = purpose;
        this.documentType = documentType;
        this.time = time;
        this.userTokenOtherDocs = userTokenOtherDocs;

    }

    public String getUserTokenOtherDocs() {
        return userTokenOtherDocs;
    }

    public void setUserTokenOtherDocs(String userTokenOtherDocs) {
        this.userTokenOtherDocs = userTokenOtherDocs;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDuration() {
        return purpose;
    }

    public void setDuration(String purpose) {
        this.purpose = purpose;
    }

    public Map getTime() {
        return time;
    }

    public void setTime(Map time) {
        this.time = time;
    }
}
