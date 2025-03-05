package org.example.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductOfArrayExceptSelf {

    /* Idea:
    Multiply number from previous multiplication result (a -> ab -> abc -> ....)

    A   B   C   D
    1 	A 	AB 	ABC (Front) -> iterate from firstIndex+1 -> lastIndex (LOGIC_1)
    BCD	CD	D	1   (Back)  -> iterate from lastIndex-1 -> firstIndex (LOGIC_2)
    ============================= x
    solution(n) = front(n) * back(n)
    * */
    public static int[] solution(int[] nums) {
        int totalNumber = nums.length;
        int firstIndex = 0;
        int lastIndex = totalNumber-1;

        int[] frontProduct = new int[totalNumber];
        int[] backProduct = new int[totalNumber];
        int[] result = new int[totalNumber];

        frontProduct[0] = 1;
        backProduct[lastIndex] = 1;

        // (LOGIC_1)
        for (int i = firstIndex+1; i <= lastIndex; i++) {
            frontProduct[i] = frontProduct[i-1] * nums[i-1];
        }

        // (LOGIC_2)
        for (int i = lastIndex-1; i >= firstIndex; i--) {
            backProduct[i] = backProduct[i+1] * nums[i+1];

        }

        for (int i = 0; i <= lastIndex; i++) {
            result[i] = backProduct[i] * frontProduct[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {1,2,4,6};
        int[] output = {48,24,12,8};

        int[] result = solution(input);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(output));
    }
}