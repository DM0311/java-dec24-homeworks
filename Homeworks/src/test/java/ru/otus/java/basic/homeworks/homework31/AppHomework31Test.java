package ru.otus.java.basic.homeworks.homework31;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class AppHomework31Test {
    @ParameterizedTest
    @MethodSource("arrayPartOK")
    void getArrayPartOK(int[] sourceArray) {
        Assertions.assertArrayEquals(new int[]{2, 2}, AppHomework31.getArrayPart(sourceArray));

    }

    @ParameterizedTest
    @MethodSource("arrayPartFail")
    void getArrayPartFail(int[] sourceArray) {
        Assertions.assertThrows(RuntimeException.class, () -> AppHomework31.getArrayPart(sourceArray));
    }

    public static Stream<Arguments> arrayPartOK() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 1, 2, 2}));
        return out.stream();
    }

    public static Stream<Arguments> arrayPartFail() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{2, 2, 2, 2}));
        return out.stream();
    }


    @ParameterizedTest
    @MethodSource("checkArray")
    void checkArray(int[] sourceArray, boolean result) {
        Assertions.assertEquals(result,AppHomework31.checkArray(sourceArray));
    }

    public static Stream<Arguments> checkArray() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1,2}, true));
        out.add(Arguments.arguments(new int[]{1,1}, false));
        out.add(Arguments.arguments(new int[]{1,3}, false));
        out.add(Arguments.arguments(new int[]{1,2,2,1}, true));
        return out.stream();
    }
}