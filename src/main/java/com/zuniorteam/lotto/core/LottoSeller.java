package com.zuniorteam.lotto.core;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    public static final int LOTTO_PRICE = 1000;

    private final LottoGenerator lottoGenerator;

    public LottoSeller(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> sell(int money) {
        validate(money);

        final int size = money / LOTTO_PRICE;

        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            lottos.add(lottoGenerator.generate());
        }

        return lottos;
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액이 나누어 떨어지지 않습니다");
        }
    }
}
