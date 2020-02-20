package com.zuniorteam.lotto;

import com.zuniorteam.lotto.core.*;
import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.view.console.InputView;
import com.zuniorteam.lotto.view.console.OutputView;
import com.zuniorteam.lotto.vo.LottoNumber;
import com.zuniorteam.lotto.render.InputRender;

import java.util.List;

public class LottoGameBoard {

    private final LottoSeller lottoSeller = new LottoSeller(new LottoMachine());
    private final LottoOffice lottoOffice = new LottoOffice();

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame() {
        final Integer insertedMoney = inputView.scanMoney();
        final LottoBuyer lottoBuyer = new LottoBuyer(insertedMoney, lottoSeller.sell(insertedMoney));

        outputView.printLottos(lottoBuyer.getLottoNumbers());

        final List<LottoNumber> winningNumbers = InputRender.getWinningNumbers(inputView.scanWinningNumbers());

        final LottoResult lottoResult = lottoOffice.getLottoResult(lottoBuyer, winningNumbers);

        outputView.printLottoResult(lottoResult);
    }

}
