package org.brainstation.backend.user;

public class User {

    private  int userid;
    private String firstName,lastName;
    private String email;
    private String role;

    public User(){

    }

    public User( String firstName, String lastName, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
