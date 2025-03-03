package org.example.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EncodeDecodeStrings {

    public static String encode(List<String> strs) {
        StringBuilder encodedText = new StringBuilder();
        for (String word : strs) {
            encodedText.append(word.length() + "#" + word);
        }

        return encodedText.toString();
    }

    public static List<String> decode(String str) {
        List<String> decodedText = new ArrayList<>();

        int counter = 0;

        while (counter < str.length()) {
            StringBuilder wordLengthStr = new StringBuilder();

            while ('#' != str.charAt(counter)) {
                wordLengthStr.append(str.charAt(counter));
                counter++;
            }

            int wordLength = Integer.parseInt(wordLengthStr.toString());

            counter++;
            decodedText.add(str.substring(counter, counter + wordLength));
            counter += wordLength;
        }

        return decodedText;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("neet","code","love","you");
        List<String> output = Arrays.asList("neet","code","love","you");

        String encodedText = encode(input);
        List<String> rawText = decode(encodedText);

        System.out.println(rawText);
    }
}