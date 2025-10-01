package com.challenges.misc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeating {

        public static Character firstNonRepeatingChar(String s) {
            var characters = new LinkedHashMap<Character, Integer>();

            var ca = s.toCharArray();

            for(char c: ca) {
                characters.merge(c, 1, Integer::sum);
            }

            for(var entry: characters.entrySet()) {
                if(entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return null;


        }

        public static void main(String[] args) {
            System.out.println(firstNonRepeatingChar("leetcode"));
            System.out.println(firstNonRepeatingChar("hello"));
            System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

        }

    }
