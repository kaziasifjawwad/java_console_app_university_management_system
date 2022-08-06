package org.brainstation.backend.consoleDataBase.database;
import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelperDatabaseClass {


    public static  ArrayList<Integer> listBuilder(String pattern){
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] parseInteger = pattern.substring(1,pattern.length()-1).split(",");
        if(parseInteger.length<=1) return list;
        for(int index=0;index<parseInteger.length;index++) {
            list.
                    add(Integer
                            .parseInt(parseInteger[index]
                                    .replaceAll("\\s+","")));
        }
        return list;
    }

    public static void saveData(List list,String path){
        System.out.println(list.toString());
        try {
            FileWriter myWriter = new FileWriter(path);
            for(int index = 0;index<list.size();index++){
                myWriter.write(list.get(index).toString()+"\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void saveLine(List list,String path){
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(list.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
