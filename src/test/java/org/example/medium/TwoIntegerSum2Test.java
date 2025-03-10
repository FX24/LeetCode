package org.example.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoIntegerSum2Test {

    TwoIntegerSum2 main = new TwoIntegerSum2();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[]{1,2,3,4}, 3, new int[]{1,2})
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int[] input, int target, int[] expected) {
        assertArrayEquals(main.solution(input, target), expected);
    }
}