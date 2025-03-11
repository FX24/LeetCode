package org.example.medium;

import org.example.easy.TwoSums;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubarrayof1sAfterDeletingOneElementTest {

    LongestSubarrayof1sAfterDeletingOneElement main = new LongestSubarrayof1sAfterDeletingOneElement();

    @Test
    void solution() {
        int[] input = {1,0,1,1,1,1,1,1,0,1,1,1,1,1};
        int expected = 11;

        int actual = main.solution(input);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testCase() {
        return Stream.of(
                arguments(new int[] {1,1,0,1}, 3),
                arguments(new int[] {0,1,1,1,0,1,1,0,1}, 5),
                arguments(new int[] {1,1,1}, 2),
                arguments(new int[] {0}, 0),
                arguments(new int[] {0,1,1,1,1,1}, 5),
                arguments(new int[] {1,0,1,1,1,1,1,1,0,1,1,1,1,1}, 11)
        );
    }

    @ParameterizedTest
    @MethodSource
    void testCase(int[] input, int expected) {
        assertEquals(expected, main.solution(input))
        ;
    }
}