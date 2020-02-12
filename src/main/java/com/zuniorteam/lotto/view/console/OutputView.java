package com.zuniorteam.lotto.view.console;

import com.zuniorteam.lotto.core.Lotto;
import com.zuniorteam.lotto.dto.GameResult;

import java.util.List;

public class OutputView {

    public void printLottos(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printGameResult(GameResult gameResult) {

    }
}
