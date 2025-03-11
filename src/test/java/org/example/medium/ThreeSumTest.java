package org.example.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ThreeSumTest {

    ThreeSum main = new ThreeSum();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[]{-1,0,1,2,-1,-4}, List.of(List.of(-1,-1,2), List.of(-1,0,1)))
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int[] input, List<List<Integer>> expected) {
        List<List<Integer>> result = main.solution(input);

        for (int i = 0; i < result.size(); i++) {
            assertArrayEquals(result.get(i).toArray(new Integer[0]), expected.get(i).toArray(new Integer[0]));
        }

    }
}