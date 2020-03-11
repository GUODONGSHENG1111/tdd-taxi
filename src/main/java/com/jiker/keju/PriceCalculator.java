package com.jiker.keju;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class PriceCalculator {
    public static final double INIT_DISTANCE = 2;
    public static final double INIT_PRICE = 6;
    public static final double EIGHT_DISTANCE = 8;
    public static final double WAIT_PRICE = 0.25;
    public static final double LESS_EIGHT_PRICE = 0.8;
    public static final double BEYOND_EIGHT_PRICE = 1.2;


    public double calculator(double distance, int waitTime) {
        double distancePrice = 0;
        double waitPrice = WAIT_PRICE * waitTime;
        if (distance <= INIT_DISTANCE) {
            distancePrice = INIT_PRICE;
        }
        if (INIT_DISTANCE < distance && distance <= EIGHT_DISTANCE) {
            distancePrice = INIT_PRICE + (distance - INIT_DISTANCE) * LESS_EIGHT_PRICE;
        }
        if (distance > EIGHT_DISTANCE) {
            distancePrice = INIT_PRICE + (EIGHT_DISTANCE - INIT_DISTANCE) *
                    LESS_EIGHT_PRICE + (distance - EIGHT_DISTANCE) * BEYOND_EIGHT_PRICE;
        }
        return new BigDecimal(distancePrice + waitPrice).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public  String getPriceResult(String filePath) throws IOException {
        String receipt = "";
        Map<Double, Integer> paramMap = new FileParser().fileReader(filePath);
        for (Map.Entry<Double, Integer> entry : paramMap.entrySet()) {
            double price = calculator(entry.getKey(), entry.getValue());
            receipt += "\n收费" + new Double(price).intValue() + "元";
        }
        return receipt.trim();
    }
}
