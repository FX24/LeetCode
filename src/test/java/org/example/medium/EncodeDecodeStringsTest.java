package org.example.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EncodeDecodeStringsTest {
    EncodeDecodeStrings main = new EncodeDecodeStrings();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(Arrays.asList("neet", "code", "love"))
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(List<String> input) {
        String encodedText = main.encode(input);
        List<String> decodedText = main.decode(encodedText);
        assertIterableEquals(decodedText, input);
    }
}