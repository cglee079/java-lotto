package com.zuniorteam.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionUtilTest {


    @DisplayName("컬렉션 is 유니크")
    @ParameterizedTest(name = "value : {0}, expected : {1}")
    @MethodSource("uniqueTestStream")
    void testIsUnique(List<Integer> numbers, boolean expected) {
        assertThat(CollectionUtil.isUnique(numbers)).isEqualTo(expected);
    }


    @DisplayName("List 병합")
    @Test
    void testMerge() {
        final List<Integer> base = Arrays.asList(1, 2);
        final List<Integer> another = Arrays.asList(2, 3, 4);
        assertThat(CollectionUtil.merge(base, another)).containsExactly(1, 2, 2, 3, 4);
    }

    private static Stream uniqueTestStream() {
        return Stream.of(
                Arguments.of(Arrays.asList(1), true),
                Arguments.of(Arrays.asList(1, 2, 3), true),
                Arguments.of(Arrays.asList(2, 2, 3), false),
                Arguments.of(Arrays.asList(2, 2, 2), false)
        );
    }


}
