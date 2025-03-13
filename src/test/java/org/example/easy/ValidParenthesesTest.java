package org.example.easy;

import org.example.SampleTask;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidParenthesesTest {

    ValidParentheses main = new ValidParentheses();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments("[]", true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(String input, Boolean expected) {
        assertEquals(main.solution(input), expected);
    }
}