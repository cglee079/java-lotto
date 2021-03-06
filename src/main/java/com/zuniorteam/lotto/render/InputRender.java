package com.zuniorteam.lotto.render;

import com.zuniorteam.lotto.core.Lotto;
import com.zuniorteam.lotto.core.Lottos;
import com.zuniorteam.lotto.vo.LottoNumber;
import com.zuniorteam.lotto.vo.Money;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class InputRender {

    private InputRender() {
    }

    private static final String NUMBER_SPLIT_TOKEN = ",";

    public static Lotto getWinningLotto(String input) {
        return getLotto(input);
    }

    public static LottoNumber getBonusNumber(int bonusNumber) {
        return new LottoNumber(bonusNumber);
    }

    public static Lottos getLottos(List<String> lines) {
        final List<Lotto> appointLottos = lines.stream()
                .filter(l -> l.length() > 0)
                .map(InputRender::getLotto)
                .collect(toList());
        
        return new Lottos(appointLottos);
    }

    private static Lotto getLotto(String line) {
        List<LottoNumber> lottoNumbers = Arrays.stream(line.split(NUMBER_SPLIT_TOKEN))
                .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
                .collect(toList());

        return new Lotto(lottoNumbers);

    }

    public static Integer getNumberOfAppointLottos(Integer scanNumber) {
        if (scanNumber < 0) {
            throw new IllegalArgumentException("적절하지 않은 수동 넘버 개수입니다.");
        }
        return scanNumber;
    }

    public static Money getInsertMoney(Integer scanMoney) {
        return Money.of(scanMoney);
    }
}
