package org.example.easy;

public class ValidPalindrome {
    public static boolean solution(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left <= right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }

            Character leftCharacter = Character.toLowerCase(s.charAt(left));
            Character rightCharacter = Character.toLowerCase(s.charAt(right));
            if (leftCharacter != rightCharacter) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "0P";
        Boolean result = solution(input);
        Boolean expected = false;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}