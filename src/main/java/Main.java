import backend.consoleDataBase.JsonDatabase;
import backend.user.Teacher;

public class Main {
    public static void main(String[] args) {
        JsonDatabase database = JsonDatabase.getInstance("src/database/database.json");
        database.saveUser(new Teacher("asif", "jawwad", "asif@gmail.com","student"));
        database.saveUser(new Teacher("arifuzzaman", "munaf", "munaf@gmail.com","student"));


    }


}
