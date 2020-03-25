package com.zuniorteam.lotto;

import com.zuniorteam.lotto.web.route.PostBuyLottoRoute;
import com.zuniorteam.lotto.web.route.PostMatchLottoRoute;

import static spark.Spark.*;

public class LottoGameWebBoard {
    private static final String RESOURCE_DIRECTORY = "/templates";
    public static final int PORT = 8080;

    public void playGame() {
        port(PORT);

        staticFiles.location(RESOURCE_DIRECTORY);

        post("/buyLotto", new PostBuyLottoRoute());
        post("/matchLotto", new PostMatchLottoRoute());
    }

}
