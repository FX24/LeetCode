package org.example.pattern;

/* TODO [Sliding Window]
    - If the window is valid, expand right. Else, shrink left.
    - Complexity: O(n)
*/
public class SlidingWindows {
    //            i
    // nums: [5,7,2,8]
    //        j
    // TODO : SAMPLE CODE
//    int longestWindow(int[] nums) {
//        int max;
//        for (int i = 0, j = 0; i < nums.length; i++) {
//            // code using nums[i] to update the state
//            // that might invalidate the window
//            for (; invalid(); j++) {
//                // code using nums[j] to update the state
//                // and shrink the left edge while the window is invalid
//            }
//            // longest window so far = length([i, j])
//            max = Math.max(ans, i - j + 1);
//        }
//        return max;
//    }

    public static void main(String[] args) {
        String[] input1 = { "abcabcbb", "bbbbb", "pwwkew" };
        for (String input : input1) {
            System.out.println(
                    String.format(
                            "lengthOfLongestSubstringWithoutRepeating(\"%s\") = %d",
                            input,
                            lengthOfLongestSubstringWithoutRepeating(input)));
        }

        System.out.println();

        String[] input2 = { "eceba", "aa" };
        for (String input : input2) {
            for (int k = 1; k <= input.length(); k++) {
                System.out.println(
                        String.format(
                                "lengthOfLongestSubstringKDistinct(\"%s\", %d) = %d",
                                input,
                                k,
                                lengthOfLongestSubstringKDistinct(input, k)));
            }
        }
    }
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static int lengthOfLongestSubstringWithoutRepeating(String s) {
        int[] map = new int[256];
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            map[s.charAt(i)]++; // update state using s[i]
            for (; map[s.charAt(i)] > 1; j++) map[s.charAt(j)]--; // shrink the left edge using s[j]
            max = Math.max(max, i - j + 1); // longest window so far
        }
        return max; // longest window
    }

    // https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int cnt = 0, max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c]++;
            if (map[c] == 1) cnt++; // update state using s[i]
            for (; cnt > k; j++) { // shrink the left edge while invalid
                c = s.charAt(j);
                map[c]--;
                if (map[c] == 0) cnt--; // update state using s[j]
            }
            max = Math.max(max, i - j + 1); // longest window so far
        }
        return max; // longest window
    }
}
