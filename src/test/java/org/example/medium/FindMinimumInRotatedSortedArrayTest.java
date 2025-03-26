package org.example.medium;

import org.example.SampleTask;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindMinimumInRotatedSortedArrayTest {

    FindMinimumInRotatedSortedArray main = new FindMinimumInRotatedSortedArray();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[]{4,5,6,7,0,1,2}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int[] input,  int expected) {
        assertEquals(main.solution(input), expected);
    }
}