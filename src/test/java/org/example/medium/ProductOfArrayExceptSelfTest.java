package org.example.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ProductOfArrayExceptSelfTest {

    ProductOfArrayExceptSelf main = new ProductOfArrayExceptSelf();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[] {1,2,4,6}, new int[]{48,24,12,8}),
                arguments(new int[] {-1,0,1,2,3}, new int[]{0,-6,0,0,0})
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int[] input, int[] expected) {
        assertArrayEquals(main.solution(input), expected);
    }
}