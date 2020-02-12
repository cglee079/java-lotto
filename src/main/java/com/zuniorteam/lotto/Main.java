package com.zuniorteam.lotto;

import com.zuniorteam.lotto.core.LottoGenerator;
import com.zuniorteam.lotto.core.LottoOffice;
import com.zuniorteam.lotto.core.LottoSeller;
import com.zuniorteam.lotto.view.console.InputView;
import com.zuniorteam.lotto.view.console.OutputView;
import com.zuniorteam.lotto.core.Lotto;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        new LottoGameBoard().playGame();

    }
}

