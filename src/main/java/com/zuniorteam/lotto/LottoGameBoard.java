package com.zuniorteam.lotto;

import com.zuniorteam.lotto.core.*;
import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.render.InputRender;
import com.zuniorteam.lotto.view.console.InputView;
import com.zuniorteam.lotto.view.console.OutputView;
import com.zuniorteam.lotto.vo.LottoNumber;
import com.zuniorteam.lotto.vo.Money;

public class LottoGameBoard {

    private final LottoSeller lottoSeller = new LottoSeller(new LottoAutoMachine());
    private final LottoOffice lottoOffice = new LottoOffice();

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame() {
        final Money insertedMoney = InputRender.getInsertMoney(inputView.scanMoney());
        final Integer numberOfAppointLotto = InputRender.getNumberOfAppointLottos(inputView.scanNumberOfAppointLottos());
        final Lottos appointLottos = InputRender.getAppointLottos(inputView.scanAppointLottos(numberOfAppointLotto));

        final LottoBuyer lottoBuyer = new LottoBuyer(insertedMoney, lottoSeller.sell(insertedMoney, appointLottos));

        outputView.printLottos(lottoBuyer.getAllLottoNumbers(), numberOfAppointLotto);

        final Lotto winningLotto = InputRender.getWinningLotto(inputView.scanWinningNumbers());
        final LottoNumber bonusNumber = InputRender.getBonusNumber(inputView.scanBonusNumber());

        final LottoResult lottoResult = lottoOffice.getLottoResult(lottoBuyer, new WinningLotto(winningLotto, bonusNumber));

        outputView.printLottoResult(lottoResult);
    }

}
