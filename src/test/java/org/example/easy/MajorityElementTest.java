package org.example.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MajorityElementTest {
    MajorityElement main = new MajorityElement();

    public static Stream<Arguments> test() {
        return Stream.of(
                arguments(new int[] {3,2,2,3}, 3, 2),
                arguments(new int[] {0,1,2,2,3,0,4,2}, 2, 5)
        );
    }

    @ParameterizedTest
    @MethodSource
    void test(int[] input,int expected) {
        int result = main.solution(input);

        Assertions.assertEquals(expected, result);
    }
}