package com.jiker.keju;

import java.io.File;
import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) {
        String receipt = "";
        //System.out.println(args[0]);
        //String url = Util.getFilePath("testData.txt");
        //System.out.println(url);
        try {
            receipt = PriceCalculator.getPriceResult(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(receipt);
    }
}
