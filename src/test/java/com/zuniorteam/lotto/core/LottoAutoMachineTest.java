package com.zuniorteam.lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoAutoMachineTest {

    @DisplayName("생성")
    @Test
    void testNewInstance(){
        assertDoesNotThrow(LottoAutoMachine::new);
    }

    @DisplayName("로또 발급 테스트")
    @Test
    void testGenerate(){
        assertDoesNotThrow(() -> new LottoAutoMachine().generate());
    }

}
