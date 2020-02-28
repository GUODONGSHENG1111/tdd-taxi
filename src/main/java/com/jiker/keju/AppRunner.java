package com.jiker.keju;

import java.io.File;
import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) {
        String receipt = "";
        try {
            String testDataFile = Util.getFilePath("testData.txt");
            receipt = PriceCalculator.getPriceResult(testDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(receipt);
    }
}
