package org.example.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveDuplicatesFromSortedArrayTest {

    RemoveDuplicatesFromSortedArray main = new RemoveDuplicatesFromSortedArray();

    @Test
    void solution() {
        int[] inputs = {0,0,1,1,1,2,2,3,3,4};
        int solution = main.solution(inputs);
        int[] uniqueNumbers = {0,1,2,3,4};


        System.out.println("Size : " + solution);
        System.out.println("Unique   : " + Arrays.toString(uniqueNumbers));
        System.out.println("Solution : " + Arrays.toString(inputs));
    }

    TwoSums twoSums = new TwoSums();

    public static Stream<Arguments> twoSum() {
        return Stream.of(
                arguments(new int[] {2, 7, 11, 15}, 9, new int[]{0,1})
        );
    }

    @ParameterizedTest
    @MethodSource
    void twoSum(int[] input, int target, int[] expected) {
        assertArrayEquals(twoSums.solution(input, target), expected);
    }
}