package org.example.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GroupAnagramTest {

    GroupAnagram main = new GroupAnagram();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments((Object) new String[] {"act", "pots", "tops", "cat", "stop", "hat"}, Arrays.asList(
                Arrays.asList("hat"),
                Arrays.asList("act", "cat"),
                Arrays.asList("stop", "pots", "tops")
        )));
    }

    @ParameterizedTest
    @MethodSource
    void question(String[] input, List<List<String>> expected) {
        assertIterableEquals(main.solution(input), expected);
    }
}