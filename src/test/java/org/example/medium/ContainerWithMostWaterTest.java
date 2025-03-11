package org.example.medium;

import org.example.SampleTask;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ContainerWithMostWaterTest {

    SampleTask main = new SampleTask();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[] {1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int[] input,  int expected) {
        assertEquals(main.solution(input), expected);
    }
}