package com.jiker.keju;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class FileParser {
    public Map<Double, Integer> fileReader(String filepath) throws IOException {
        Map<Double, Integer> paramMap = new LinkedHashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        String line = "";
        lineParser(paramMap, bufferedReader);
        if (bufferedReader != null){ bufferedReader.close();}
        return paramMap;
    }

    private void lineParser(Map<Double, Integer> paramMap, BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.trim().equals("")) {
                String[] domainParam = line.split("公里");
                paramMap.put(parseDouble(domainParam[0]), parseInt(domainParam[1].split("等待")[1].split("分钟")[0]));
            }
        }
    }
}


