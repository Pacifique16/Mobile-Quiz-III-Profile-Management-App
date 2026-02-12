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

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
