package com.fran.demo;

import java.io.*;
import java.util.*;
import java.lang.*;

interface Operation {
    boolean check(int number);
}

class Number {
    public boolean checker(Operation operation, int number) {
        return operation.check(number);
    }

    public Operation isOdd() {
        return n -> n % 2 > 0;
    }

    public Operation isPalindrome() {
        return n -> String.valueOf(n).equals(new StringBuilder().append(n).reverse().toString());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Number number = new Number();
        String answer = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String line = bufferedReader.readLine().trim();
            StringTokenizer st = new StringTokenizer(line);
            int conditionToCheck = Integer.parseInt(st.nextToken());
            int numberToCheck = Integer.parseInt(st.nextToken());
            if (conditionToCheck == 1) {
                Operation operation = number.isOdd();
                boolean result = number.checker(operation, numberToCheck);
                answer = result ? "ODD" : "EVEN";
            } else if (conditionToCheck == 2) {
                Operation operation = number.isPalindrome();
                boolean result = number.checker(operation, numberToCheck);
                answer = result ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(answer);
        }
    }
}

