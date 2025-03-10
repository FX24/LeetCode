package org.example.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidPalindromeTest {

    ValidPalindrome main = new ValidPalindrome();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments("Was it a car or a cat I saw?", true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(String input,  boolean expected) {
        assertEquals(main.solution(input), expected);
    }
}