package org.example.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoSumTest {

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