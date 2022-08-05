package org.brainstation.backend.consoleDataBase.oldSystem;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter {

    public void appendStrToFile(String fileName, String str)
    {
        try {
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            // append data to a file
            Files.write(Paths.get(fileName), str.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
