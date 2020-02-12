package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("생성")
    @Test
    void testNewInstance(){
        assertDoesNotThrow(() -> new LottoGenerator());
    }

    @DisplayName("로또 발급 테스트")
    @Test
    public void testGenerate(){
        assertDoesNotThrow(() -> new LottoGenerator().generate());
    }

}
