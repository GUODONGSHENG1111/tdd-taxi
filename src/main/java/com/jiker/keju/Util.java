package com.jiker.keju;

import java.io.File;
import java.io.IOException;

public class Util {
    public String getFilePath(String fileName) {
        String testDataFile = "";
        File file = new File(Thread.currentThread().getContextClassLoader().getResource(fileName).getFile());
        try {
            testDataFile = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testDataFile;
    }

}
