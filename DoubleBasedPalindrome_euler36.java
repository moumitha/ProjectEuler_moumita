package com.moumita.ProjectEuler;

import org.junit.Assert;
import org.junit.Test;


/*
 * Double-base palindromes
 * Problem 36
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */


public class DoubleBasedPalindrome_euler36 {

    public long findSumDoubleBasedPalindromes(int MaxLimit) {
        long sum = 0;
        for(int i = 1; i < MaxLimit; i++) {
            if(isPalindrome(""+i) && isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        return sum;
    }


    public static boolean isPalindrome(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = word.length - 1;
        while (end > start) {
            if (word[start] != word[end]) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    @Test
    public void TestSumDoubleBasedPalindromesWithMillion(){
        int MaxLimit = 1000000;
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(findSumDoubleBasedPalindromes(MaxLimit), 872187);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //93ms
    }

    @Test
    public void TestSumDoubleBasedPalindromesWithTen(){
        int MaxLimit = 10;
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(findSumDoubleBasedPalindromes(MaxLimit), 25);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //0ms
    }

    @Test
    public void TestSumDoubleBasedPalindromesWithOne(){
        int MaxLimit = 1;
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(findSumDoubleBasedPalindromes(MaxLimit), 0);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //0ms
    }



}
