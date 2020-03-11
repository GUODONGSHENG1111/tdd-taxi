package com.jiker.keju;

import java.io.File;
import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) {
        String receipt = "";
        try {
            receipt = new PriceCalculator().getPriceResult("src/main/resources/" + args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(receipt);
    }
}
