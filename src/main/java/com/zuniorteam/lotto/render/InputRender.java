package com.zuniorteam.lotto.render;

import com.zuniorteam.lotto.core.Lotto;
import com.zuniorteam.lotto.view.console.InputView;
import com.zuniorteam.lotto.vo.LottoNumber;
import com.zuniorteam.lotto.vo.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public final class InputRender {

    private final InputView inputView;

    public InputRender(InputView inputView) {
        assert inputView != null;

        this.inputView = inputView;
    }

    private static final String NUMBER_SPLIT_TOKEN = ",";

    public Lotto getWinningLotto() {
        return getLotto(inputView.scanWinningNumbers());
    }

    public LottoNumber getBonusNumber() {
        return new LottoNumber(inputView.scanBonusNumber());
    }

    public List<Lotto> getAppointLottos(int numberOfAppointLottos) {
        return inputView.scanAppointLottos(numberOfAppointLottos).stream()
                .map(this::getLotto)
                .collect(Collectors.toList());
    }

    private Lotto getLotto(String line) {
        final List<LottoNumber> lottoNumbers = Arrays.stream(line.split(NUMBER_SPLIT_TOKEN))
                .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
                .distinct()
                .collect(toList());

        return new Lotto(lottoNumbers);
    }

    public Integer getNumberOfAppointLotto() {
        final Integer scanNumber = inputView.scanNumberOfAppointLottos();
        if(scanNumber < 0){
            throw new IllegalArgumentException("적절하지 않은 수동 넘버 개수입니다.");
        }
        return scanNumber;
    }

    public Money getInsertMoney() {
        final Integer scanMoneyAmount = inputView.scanMoney();
        return Money.of(scanMoneyAmount);
    }
}
