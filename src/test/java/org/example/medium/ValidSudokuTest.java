package org.example.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidSudokuTest {

    ValidSudoku main = new ValidSudoku();

    public static Stream<Arguments> question() {
        return Stream.of(
                arguments(new char[][]{
                        {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                        {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                        {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                        {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'}}, false),
                arguments(new char[][]{
                        {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                        {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                        {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                        {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}, true)
        );
    }


        @ParameterizedTest
        @MethodSource
        void question ( char[][] input, boolean expected){
            assertEquals(main.solution(input), expected);
        }
    }