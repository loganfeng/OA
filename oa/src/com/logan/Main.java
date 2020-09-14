package com.logan;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        char firstChar = findChar(inputStr);
        if (firstChar != '\0') {
            System.out.println("The first letter not repeated in String is: " + firstChar);
        }
        String newStr = reWrite(inputStr);
        System.out.println("New string in order of number of occurrences and order from the original string: " + newStr);
    }

    private static char findChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            map.put(Character.toLowerCase(c), map.getOrDefault(Character.toLowerCase(c), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(Character.toLowerCase(str.charAt(i))) == 1) {
                return str.charAt(i);
            }
        }
        return '\0';
    }

    private static String reWrite(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            map.put(Character.toLowerCase(c), map.getOrDefault(Character.toLowerCase(c), 0) + 1);
        }

        List<Character> characters = new ArrayList<>();
        for (char c : str.toCharArray()) {
            characters.add(c);
        }
        Collections.sort(characters, (a, b) -> map.get(Character.toLowerCase(a)) - map.get(Character.toLowerCase(b))) ;
        String result = "";
        for (char c : characters) {
            result += c;
        }
        return result;
    }
}
