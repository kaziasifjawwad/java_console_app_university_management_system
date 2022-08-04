package consoleDataBase;

import com.fasterxml.jackson.databind.ObjectMapper;
import course.Course;
import examControl.Exam;
import user.BasicUser;
import user.Student;
import user.Teacher;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JsonDatabase {
    private ObjectMapper objectMapper;
    private String dataDirectory;

    private HashMap<String, Teacher> dataBaseHashMap = new HashMap<>();

    private List<BasicUser> users = new LinkedList<>();

    private List<Course> courses = new LinkedList<>();

    private List<Exam> exams = new LinkedList<>();




    public JsonDatabase(String dataDirectory){
        this.dataDirectory = dataDirectory;
        this.objectMapper = new ObjectMapper();
    }
    public void saveData(Object object){
        try{
            objectMapper.writeValue(new File(this.dataDirectory), object);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
