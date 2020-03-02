package com.zuniorteam.lotto;

import com.zuniorteam.lotto.core.*;
import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.render.InputRender;
import com.zuniorteam.lotto.view.console.InputView;
import com.zuniorteam.lotto.view.console.OutputView;
import com.zuniorteam.lotto.vo.LottoNumber;
import com.zuniorteam.lotto.vo.Money;

import java.util.List;

public class LottoGameBoard {

    private final LottoSeller lottoSeller = new LottoSeller(new LottoMachine());
    private final LottoOffice lottoOffice = new LottoOffice();

    private final InputRender inputRender = new InputRender(new InputView());
    private final OutputView outputView = new OutputView();

    public void playGame() {
        final Money insertedMoney = inputRender.getInsertMoney();
        final Integer numberOfAppointLotto = inputRender.getNumberOfAppointLotto();
        final List<Lotto> appointLottos = inputRender.getAppointLottos(numberOfAppointLotto);

        final LottoBuyer lottoBuyer = new LottoBuyer(insertedMoney, lottoSeller.sell(insertedMoney, appointLottos));

        outputView.printLottos(lottoBuyer.getLottoNumbers(), numberOfAppointLotto);

        final Lotto winningLotto = inputRender.getWinningLotto();
        final LottoNumber bonusNumber = inputRender.getBonusNumber();

        final LottoResult lottoResult = lottoOffice.getLottoResult(lottoBuyer, new WinningLotto(winningLotto, bonusNumber));

        outputView.printLottoResult(lottoResult);
    }

}
