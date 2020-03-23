package com.zuniorteam.lotto;

import com.zuniorteam.lotto.core.LottoAutoMachine;
import com.zuniorteam.lotto.core.LottoOffice;
import com.zuniorteam.lotto.core.LottoSeller;
import com.zuniorteam.lotto.view.console.InputView;
import com.zuniorteam.lotto.view.console.OutputView;
import com.zuniorteam.lotto.web.route.PostBuyLottoRoute;
import com.zuniorteam.lotto.web.route.PostMatchLottoRoute;

import static spark.Spark.*;

public class LottoGameWebBoard {
    private static final String RESOURCE_DIRECTORY = "/templates";

    public void playGame() {
        port(8080);

        staticFiles.location(RESOURCE_DIRECTORY);

        post("/buyLotto", new PostBuyLottoRoute());
        post("/matchLotto", new PostMatchLottoRoute());
    }


}
