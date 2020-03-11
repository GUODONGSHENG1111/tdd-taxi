package com.jiker.keju;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class PriceCalculatorTest {
    @Test
    public void should_return_init_price_less_two_kilometers() {
        PriceCalculator priceCalculator = new PriceCalculator();
        assertEquals(6, priceCalculator.calculator(1.5, 0), 0);
        assertEquals(6, priceCalculator.calculator(1.5, 1), 0);
        assertEquals(7, priceCalculator.calculator(1.5, 2), 0);
        assertEquals(7, priceCalculator.calculator(1.5, 3), 0);
    }

    @Test
    public void should_return_increase_price_less_eight_kilometers() {
        PriceCalculator priceCalculator = new PriceCalculator();
        assertEquals(7, priceCalculator.calculator(3, 0), 0);
        assertEquals(11, priceCalculator.calculator(7, 2), 0);
    }

    @Test
    public void should_return_increase_price_beyond_eight_kilometers() {
        PriceCalculator priceCalculator = new PriceCalculator();
        assertEquals(13, priceCalculator.calculator(10, 0), 0);
        assertEquals(26, priceCalculator.calculator(20, 3), 0);
    }

    @Test
    public void should_return_price_result() throws IOException {
        String receipt = "收费6元" +
                "\n收费7元" +
                "\n收费13元" +
                "\n收费7元";
        assertEquals(receipt, new PriceCalculator().getPriceResult(new Util().getFilePath("testData.txt")));
    }
}