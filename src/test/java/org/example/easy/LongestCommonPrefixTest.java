package org.example.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestCommonPrefixTest {

    LongestCommonPrefix main = new LongestCommonPrefix();

    public static Stream<Arguments> longestCommonPrefix() {
        return Stream.of(
                arguments(new String[] {"ab", "a"}, "a"),
                arguments(new String[] {"flower","flow","flight"}, "fl"),
                arguments(new String[] {"dog","racecar","car"}, "")
        );
    }

    @ParameterizedTest
    @MethodSource
    void longestCommonPrefix(String[] input, String expected) {
        assertEquals(main.solution(input), expected);
    }


}