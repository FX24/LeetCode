package org.example.medium;

import org.example.SampleTask;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SearchInRotatedSortedArrayTest {

    SearchInRotatedSortedArray main = new SearchInRotatedSortedArray();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[] {3,4,5,6,1,2}, 1, 4)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int[] input,  int target, int expected) {
        assertEquals(main.solution(input, target), expected);
    }
}