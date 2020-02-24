package com.zuniorteam.lotto.render;

import com.zuniorteam.lotto.core.Lotto;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;


public final class InputRender {

    private InputRender() {}

    private static final String WINNING_NUMBER_SPLIT_TOKEN = ",";

    public static Lotto getWinningLotto(String input) {
        final List<LottoNumber> lottoNumbers = Arrays.stream(input.split(WINNING_NUMBER_SPLIT_TOKEN))
                .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
                .distinct()
                .collect(toList());

        return new Lotto(lottoNumbers);
    }

    public static LottoNumber getBonusNumber(int bonusNumber) {
        return new LottoNumber(bonusNumber);
    }
}
