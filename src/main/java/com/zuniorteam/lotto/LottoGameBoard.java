package com.zuniorteam.lotto;

import com.zuniorteam.lotto.core.*;
import com.zuniorteam.lotto.dto.GameResult;
import com.zuniorteam.lotto.view.console.InputView;
import com.zuniorteam.lotto.view.console.OutputView;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.List;
import java.util.Map;

public class LottoGameBoard {

    private final LottoSeller lottoSeller = new LottoSeller(new LottoGenerator());
    private final LottoOffice lottoOffice = new LottoOffice();

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame() {
        final Integer insertedMoney = inputView.scanMoney();

        final List<Lotto> lottos = lottoSeller.sell(insertedMoney);

        outputView.printLottos(lottos);

        final List<LottoNumber> winNumbers = inputView.scanWinNumber();
        final Map<Integer, Integer> results = lottoOffice.getResult(lottos, winNumbers);

        final GameResult gameResult = LottoCalculator.calculate(results, insertedMoney);
        outputView.printGameResult(gameResult);
    }
}
