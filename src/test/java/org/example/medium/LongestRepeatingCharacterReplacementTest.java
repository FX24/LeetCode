package org.example.medium;

import org.example.SampleTask;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestRepeatingCharacterReplacementTest {

    LongestRepeatingCharacterReplacement main = new LongestRepeatingCharacterReplacement();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments("XYYX", 2 , 4),
                arguments("AAABABB", 1 , 5)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(String input, int k, int expected) {
        assertEquals(main.solution(input, k), expected);
    }
}