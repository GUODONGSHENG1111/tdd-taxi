package com.jiker.keju;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FileParserTest {
    @Test
    public void should_not_return_null() throws IOException {
        Map<Double, Integer> paramMap = new LinkedHashMap<>();
        paramMap.put(1.0, 0);
        paramMap.put(3.0, 0);
        paramMap.put(10.0, 0);
        paramMap.put(2.0, 3);
        Assert.assertNotNull(new FileParser().fileReader(new Util().getFilePath("testData.txt")));
        Assert.assertEquals(paramMap,new FileParser().fileReader(new Util().getFilePath("testData.txt")));
    }
}