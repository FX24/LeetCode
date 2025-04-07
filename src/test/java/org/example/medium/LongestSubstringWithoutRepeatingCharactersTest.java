package org.example.medium;

import org.example.SampleTask;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubstringWithoutRepeatingCharactersTest {

    LongestSubstringWithoutRepeatingCharacters main = new LongestSubstringWithoutRepeatingCharacters();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments("zxyzxyz", 3),
                arguments("xxxx", 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(String input,  int expected) {
        assertEquals(main.solution(input), expected);
    }
}