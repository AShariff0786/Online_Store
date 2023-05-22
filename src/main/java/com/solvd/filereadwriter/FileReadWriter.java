package com.solvd.filereadwriter;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class FileReadWriter {

    public static String wordCounter(String word, HashMap<String, Integer> unique){
        String temp;
        temp = StringUtils.lowerCase(word).replaceAll("\\p{P}", "");
        if(unique.containsKey(temp)){
            return "The word: " + temp + " was found " + unique.get(temp) + " amount of times.";
        }
        return "Word was not found.";
    }

    public static void main(String[] args) throws IOException {
        //Opens file
        File input = new FileUtils().getFile("../online-store/src/main/resources/input.txt");
        File output = new FileUtils().getFile("../online-store/src/main/resources/output.txt");

        //Reads file
        String str = FileUtils.readFileToString(input, StandardCharsets.UTF_8);

        //Converts line to lowercase and removes all punctuation
        str = StringUtils.lowerCase(str).replaceAll("\\p{P}", "");
        String[] words = StringUtils.split(str);

        //Stores unique words from file
        HashMap<String, Integer> unique = new HashMap<>();

        Arrays.stream(words).forEach((word-> {
            if (unique.containsKey(word)) {
                unique.put(word, unique.get(word) + 1);
            } else {
                unique.put(word, 1);
            }
        }));

        //Writes Number of unique words to file and find the amount of times a specific word appears
        FileUtils.write(output, unique + "\nThere are " + unique.size() + " unique words.\n" +
                wordCounter("over!!!!", unique), StandardCharsets.UTF_8);
    }
}
