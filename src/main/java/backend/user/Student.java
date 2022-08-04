package backend.user;

public class Student extends User implements BasicUser{


    public Student(){
    }

    public Student(String firstName, String lastName, String email, String role) {
        super(firstName, lastName, email, role);
    }

    @Override
    public void createAccount() {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public String toString() {
        return "Student{}";
    }
}
