package user;

public class Student extends User implements BasicUser{



    public Student(String username, String firstName, String lastName, String email, String role) {
        super(username, firstName, lastName, email, role);
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
