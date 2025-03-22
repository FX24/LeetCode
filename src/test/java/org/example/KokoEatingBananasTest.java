package org.example;

import org.example.medium.KokoEatingBananas;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KokoEatingBananasTest {

    KokoEatingBananas main = new KokoEatingBananas();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[]{1,4,3,2}, 9, 2)
        );
    }

    @ParameterizedTest
    @MethodSource
    void question(int[] input,  int targetHour, int expected) {
        assertEquals(main.solution(input, targetHour), expected);
    }
}