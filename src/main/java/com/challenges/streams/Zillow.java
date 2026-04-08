package com.challenges.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Zillow {
    static List<String> matchSavedSearch(int propertyId, String propertyCity, String propertyState, int propertySft, int propertyPrice, String propertyType, List<String> savedSearches) {

        return  savedSearches.stream().filter(s -> {
            List<String> elements = Arrays.stream(s.split("/")).toList();
            String location = elements.get(1);

            return validateSearch(elements.get(2), propertySft) &&
                    validateSearch(elements.get(3), propertyPrice) && location.equals(propertyCity+","+propertyState);
        }).toList();
    }
    private static boolean validateSearch(String element, int prop) {
        Integer max = 0;
        Integer min = Integer.valueOf(element.substring(0,element.indexOf("_")));
        if(Character.isDigit(element.charAt(element.indexOf("_") + 1))){
            max =Integer.valueOf(element.substring(element.indexOf("_") + 1
                    , element.lastIndexOf("_")));
        }
        return prop >= min && (prop <= max || max == 0);

    }
    public static void main(String args[] ) throws Exception {
        for (int i = 0; i < 3; i++) {
            int propertyId;
            String propertyCity;
            String propertyState;
            int propertySft;
            int propertyPrice;
            String propertyType;
            int savedSearchCount;
            List<String> savedSearches;

            List<String> input = Files.readAllLines(Paths.get(String.format("input00%d.txt", i)));
            propertyId = Integer.parseInt(input.get(0));
            propertyCity = input.get(1);
            propertyState = input.get(2);
            propertySft = Integer.parseInt(input.get(3));
            propertyPrice = Integer.parseInt(input.get(4));
            propertyType = input.get(5);
            savedSearchCount = Integer.parseInt(input.get(6));
            savedSearches = input.subList(7, input.size());

            List<String> results = matchSavedSearch(propertyId, propertyCity, propertyState, propertySft, propertyPrice, propertyType, savedSearches);
            System.out.println("Result for input 00" + i + ".txt");
            for (String result : results) {
                System.out.println(result);
            }
        }
    }
/*    456
    Austin
            TX
2100
        600000
    Condo
4
        /SanFrancisco,CA/1230_2500_sft/300000_600000_price
/SanFrancisco,CA/1400_1550_sft/600000_price
/SanFrancisco,CA/1550_sft/100000_600000_price
/Austin,TX/2000_2500_sft/400000_price*/
}
