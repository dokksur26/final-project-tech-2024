package com.example.signuppage;
public class HelperClass {
    public HelperClass() {
    }

    String signupEmail, signupPassword, signupConfirm;

    public String getSignup_email() {
        return signupEmail;
    }

    public void setSignup_email(String signup_email) {
        this.signupEmail = signup_email;
    }

    public String getSignup_password() {
        return signupPassword;
    }

    public void setSignup_password(String signup_password) {
        this.signupPassword = signup_password;
    }

    public String getConfirm() {
        return signupConfirm;
    }

    public void setConfirm(String confirm) {
        this.signupConfirm = confirm;
    }

    public HelperClass(String signup_email, String signup_password, String confirm) {
        this.signupEmail = signup_email;
        this.signupPassword = signup_password;
        this.signupConfirm = confirm;
    }
}