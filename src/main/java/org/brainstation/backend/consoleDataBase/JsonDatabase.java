package org.brainstation.backend.consoleDataBase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.brainstation.backend.course.Course;
import org.brainstation.backend.examControl.Exam;
import org.brainstation.backend.section.Section;
import org.brainstation.backend.user.User;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JsonDatabase {
    private ObjectMapper objectMapper;
    private String dataDirectory;

    private HashMap<String, Object> dataBaseHashMap = new HashMap<>();

    private List<User> users = new LinkedList<>();

    private List<Course> courses = new LinkedList<>();

    private List<Exam> exams = new LinkedList<>();

    private List<Section> sections = new LinkedList<>();

    private static JsonDatabase database;

    private  JsonDatabase(){}

    public static JsonDatabase getInstance(String dataDirectory){
        if(JsonDatabase.database==null){
            JsonDatabase.database = new JsonDatabase();
            JsonDatabase.database.dataDirectory = dataDirectory;
            JsonDatabase.database.objectMapper = new ObjectMapper();

            try{
                JsonDatabase.database.dataBaseHashMap = JsonDatabase.database.objectMapper.
                        readValue(new File(dataDirectory), HashMap.class);
            }catch (Exception e){
                System.out.println("No data found");
            }
        }
        return JsonDatabase.database;
    }

    public void saveData(){
        this.dataBaseHashMap.put("users",this.users);
        this.dataBaseHashMap.put("courses",this.courses);
        this.dataBaseHashMap.put("exams",this.exams);
        this.dataBaseHashMap.put("sections",this.sections);
        try{
            objectMapper.writeValue(new File(this.dataDirectory), dataBaseHashMap);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void saveUser(User user){
        this.users.add(user);
        this.dataBaseHashMap.put("users",this.users);
        saveData();
    }

    public void saveCourse(Course course){
        this.courses.add(course);
        saveData();
    }

    public void saveExam(Exam exam){
        this.exams.add(exam);
        saveData();
    }

    public void saveSection(Section section){
        this.sections.add(section);
        saveData();
    }

    public HashMap<String, Object> getDataBaseHashMap() {
        return dataBaseHashMap;
    }
}
