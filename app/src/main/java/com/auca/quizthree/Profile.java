package com.auca.quizthree;

public class Profile {
    private String names;
    private String email;
    private String phoneNo;

    public Profile(String names, String email, String phoneNo) {
        this.names = names;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
