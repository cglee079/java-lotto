package com.zuniorteam.lotto;

import com.zuniorteam.lotto.core.*;
import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.view.console.InputView;
import com.zuniorteam.lotto.view.console.OutputView;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.List;

public class LottoGameBoard {

    private final LottoSeller lottoSeller = new LottoSeller(new LottoGenerator());
    private final LottoOffice lottoOffice = new LottoOffice();

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame() {
        final Integer insertedMoney = inputView.scanMoney();
        final List<Lotto> lottos = lottoSeller.sell(insertedMoney);

        final LottoBuyer lottoBuyer = new LottoBuyer(insertedMoney, lottos);

        outputView.printLottos(lottos);

        final List<LottoNumber> winNumbers = inputView.scanWinNumber();

        final LottoResult lottoResult = lottoOffice.getLottoResult(lottoBuyer, winNumbers);

        outputView.printLottoResult(lottoResult);
    }
}
