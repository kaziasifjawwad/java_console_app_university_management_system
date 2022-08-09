package org.brainstation.backend.consoleDataBase.database;
import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;
import org.brainstation.backend.section.Section;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SectionDatabase {
    private List<Section> sectionList;

    private static SectionDatabase sectionDatabase;


    private SectionDatabase(){}

    public static SectionDatabase getInstance(){
        if(sectionDatabase==null){
            sectionDatabase = new SectionDatabase();
            sectionDatabase.setSectionlist(sectionDatabase.readList());
        }
        return sectionDatabase;
    }
    public List<Section> readList(){
        try {
            File myObj = new File(DatabaseConfiguration.sectionDataPath);
            Scanner myReader = new Scanner(myObj);
            ArrayList<Section> sectionList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(DatabaseConfiguration.splitter);
                Section tempSection = new Section(
                        Integer.parseInt(data[1]),Integer.parseInt(data[2])
                );
                tempSection.setSectionId(Integer.parseInt(data[0]));
                tempSection.setStudents(HelperDatabaseClass.listBuilder(data[4]));
                sectionList.add(tempSection);
            }
            myReader.close();
            return sectionList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Section>();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Section>();
        }
    }

    public List<Section> getSectionlist() {
        return sectionList;
    }

    public void setSectionlist(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public void saveSection(Section section,int sectionId){
        section.setSectionId(sectionId);
        this.sectionList.add(section);
        System.out.println(this.sectionList);

    }

    public Section getSectionById(int sectionId){
        for(int index=0;index<this.sectionList.size();index++){
            if(this.sectionList.get(index).getSectionId()==sectionId) return this.sectionList.get(index);
        }
        return null;
    }

    public void saveAllSection(){
        HelperDatabaseClass.saveData(this.sectionList,DatabaseConfiguration.teacherDataPath);
    }

    public void deleteSection(Section section){
        this.sectionList.remove(section);
    }
}
