package org.example.medium;

import org.example.SampleTask;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Search2DMatrixTest {

    Search2DMatrix main = new Search2DMatrix();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 5}
                }, 11, true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int[][] input, int target, boolean expected) {
        assertEquals(main.solution(input, target), expected);
    }
}