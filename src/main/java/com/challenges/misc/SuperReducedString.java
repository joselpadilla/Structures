package com.challenges.misc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class SuperReducedString {
    public static void main(String[] args) {
        System.out.printf("%s",superReducedString("aaabccddd"));
    }

    private static String superReducedString(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == stack.peek()){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.stream().toList().reversed().stream().map(String::valueOf).collect(Collectors.joining());
    }
}
