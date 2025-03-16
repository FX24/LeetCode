package org.example.medium;

import org.example.SampleTask;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GenerateParenthesesTest {

    GenerateParentheses main = new GenerateParentheses();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(3, List.of("((()))","(()())","(())()","()(())","()()()"))
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int input, List<String> expected) {
        assertArrayEquals(main.solution(input).toArray(), expected.toArray());
    }
}