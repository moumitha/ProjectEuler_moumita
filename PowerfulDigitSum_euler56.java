package com.moumita.ProjectEuler;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/*
 * https://projecteuler.net/problem=56
 * Powerful digit sum
 * Problem 56
 * A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably large:
 * one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

 * Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
 */

public class PowerfulDigitSum_euler56 {


    public static int findMaxDigitalSum(int maxLimit) {
        if(maxLimit <= 1) return 0;
        if(maxLimit == 2) return 1;

        int result = 0;
        for (int a = maxLimit-1; a > 0; a--) {
            for (int b = maxLimit-1; b > 0; b--) {
                String digitStr =  new BigInteger("" + a).pow(b).toString();
                int sum = 0;
                for (char c: digitStr.toCharArray()) {
                    int value = Character.getNumericValue(c);
                    sum += value;
                }
                result = Math.max(result, sum);
            }
        }
        return result;
    }


    @Test
    public void TestWithMaxDigitalSumWithMaxLimit(){
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(findMaxDigitalSum(100), 972);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //125ms
    }

    @Test
    public void TestWithMaxDigitalSumWithLowLimit(){
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(findMaxDigitalSum(10), 45);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //0ms
    }

    @Test
    public void TestWithMaxDigitalSumWithLowestLimit(){
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(findMaxDigitalSum(2), 1);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //0ms
    }

    @Test
    public void TestWithMaxDigitalSumWithOne(){
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(findMaxDigitalSum(1), 0);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //0ms
    }

    @Test
    public void TestWithMaxDigitalSumWithZero(){
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(findMaxDigitalSum(0), 0);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //0ms
    }

    @Test
    public void TestWithMaxDigitalSumWithNegativeNumber(){
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(findMaxDigitalSum(-14), 0);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //0ms
    }
}
