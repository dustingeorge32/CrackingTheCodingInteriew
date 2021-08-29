package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class ArraysAndStrings {
    public static boolean isUnique(String word) {
        boolean retVal = true;
        HashMap<Integer, Character> hashMap = new HashMap<Integer, Character>();
        for(Integer i = 0; i < word.length(); i++) {
            if(hashMap.containsValue(word.charAt(i))) {
                return false;
            } else{
                hashMap.put(i, word.charAt(0));
            }
        }
        return retVal;
    }

    public static boolean isUniqueNoDataStructure(String word) {
        for(int i = 0; i < word.length(); i++) {
            for(int j = 0; j < word.length() ; j++) {
                if(i == j) {
                    continue;
                }
                if(word.charAt(i) == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPermutation(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return false;
        }

        if(word1.length() != word2.length()) {
            return false;
        }
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0; i < word1.length(); i++) {
            hashSet.add(word1.charAt(i));
        }
        for(int i = 0; i < word2.length(); i++ ) {
            if(hashSet.contains(word2.charAt(i))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalineDromePerm(String word) {
        boolean retVal = true;
        if(word.isBlank() || word.isEmpty()){
            return false;
        }
        if(word == null) {
            return false;
        }
        word = word.toLowerCase();
        int[] intArray = new int[26];
        Arrays.fill(intArray, 0);
        for(int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);
            int index = ascii - 97;
            if(index < 0 || index > 25) {
                continue;
            }
            int value = intArray[index];
            intArray[index] = value + 1;
        }
        boolean oddFlag = false;
        for(int i = 0; i < intArray.length ; i++) {
            if(intArray[i] % 2 == 0) {
                continue;
            }
            if(oddFlag == false && intArray[i] % 2 == 1) {
                oddFlag = true;
                continue;
            }
            if(oddFlag == true && intArray[i] % 2 == 1) {
                return false;
            }
        }

        if(oddFlag) {
            return true;
        } else {
            return false;
        }
    }
}
