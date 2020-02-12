package com.zuniorteam.lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("생성, 성공")
    @Test
    void testNewInstance01(){
        assertDoesNotThrow(() -> new NumberGenerator());
    }

    @DisplayName("랜덤 테스트")
    @Test
    void testRandom(){
    }

}
