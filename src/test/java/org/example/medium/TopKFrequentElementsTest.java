package org.example.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TopKFrequentElementsTest {

    TopKFrequentElements main = new TopKFrequentElements();

    public static Stream<Arguments> twoSum() {
        return Stream.of(
                arguments(new int[] {1,2,2,3,3,3}, 2, new int[]{2,3})
        );
    }

    @ParameterizedTest
    @MethodSource
    void twoSum(int[] input, int target, int[] expected) {
        assertArrayEquals(main.solution(input, target), expected);
    }
}