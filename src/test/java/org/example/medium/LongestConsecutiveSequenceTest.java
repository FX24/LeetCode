package org.example.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestConsecutiveSequenceTest {

    LongestConsecutiveSequence main = new LongestConsecutiveSequence();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new int[] {2,20,4,10,3,4,5}, 4),
                arguments(new int[] {0,3,2,5,4,6,1,1}, 7)
        );
    }


        @ParameterizedTest
        @MethodSource
        void question (int[] input, int expected){
            assertEquals(main.solution(input), expected);
        }
    }