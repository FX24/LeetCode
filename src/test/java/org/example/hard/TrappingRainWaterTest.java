package org.example.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TrappingRainWaterTest {

    TrappingRainWater main = new TrappingRainWater();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[] {0,2,0,3,1,0,1,3,2,1}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int[] input,  int expected) {
        assertEquals(main.solution(input), expected);
    }
}