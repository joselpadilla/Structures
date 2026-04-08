package com.challenges.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AcmTeam {
    public static void main(String[] args) {
        acmTeam(Arrays.asList("10101", "11100", "11010", "00101")).forEach(System.out::println);
    }

    private static List<Integer> acmTeam(List<String>  topic) {

        int maxTopics = 0;
        int countTeams = 0;

        for(int i = 0; i < topic.size(); i++){
            for(int j = i + 1; j < topic.size(); j++){
                int knownTopics = 0;
                for(int k = 0; k < topic.get(i).length(); k++){
                    if(topic.get(i).charAt(k) == '1' || topic.get(j).charAt(k) == '1'){
                        knownTopics++;
                    }
                }
                if(knownTopics > maxTopics){
                    maxTopics = knownTopics;
                    countTeams = 1;
                } else if(knownTopics == maxTopics){
                    countTeams++;
                }
            }
        }
        return Arrays.asList(new Integer[]{maxTopics, countTeams});
    }

}
