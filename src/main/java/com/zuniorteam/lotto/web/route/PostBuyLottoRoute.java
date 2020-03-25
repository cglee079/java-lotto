package com.zuniorteam.lotto.web.route;

import com.zuniorteam.lotto.core.LottoAutoMachine;
import com.zuniorteam.lotto.core.LottoBuyer;
import com.zuniorteam.lotto.core.LottoSeller;
import com.zuniorteam.lotto.core.Lottos;
import com.zuniorteam.lotto.render.InputRender;
import com.zuniorteam.lotto.vo.LottoNumber;
import com.zuniorteam.lotto.vo.Money;
import org.json.JSONArray;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zuniorteam.lotto.web.render.CustomTemplateEngine.render;
import static java.util.stream.Collectors.joining;

public class PostBuyLottoRoute implements Route {

    private static final String PARAM_INPUT_MONEY = "inputMoney";
    private static final String PARAM_MANUAL_NUMBER = "manualNumber";
    private static final String VIEW_NAME = "show";

    @Override
    public Object handle(Request request, Response response) {
        final Money insertedMoney = InputRender.getInsertMoney(getInputMoney(request));
        final Lottos appointLottos = InputRender.getLottos(getAppointNumbers(request));

        final LottoSeller lottoSeller = new LottoSeller(new LottoAutoMachine());
        final LottoBuyer lottoBuyer = new LottoBuyer(insertedMoney, lottoSeller.sell(insertedMoney, appointLottos));

        Map<String, Object> model = new HashMap<>();
        model.put("inputMoney", lottoBuyer.getInsertedMoney().amount());
        model.put("buyLottos", encodeAllLottos(lottoBuyer.getAllLottoNumbers()));

        return render(model, VIEW_NAME);
    }

    private Integer getInputMoney(Request request) {
        return Integer.valueOf(request.queryParams(PARAM_INPUT_MONEY));
    }

    private List<String> getAppointNumbers(Request request) {
        return Arrays.asList(request.queryParams(PARAM_MANUAL_NUMBER).split("\n"));
    }

    private JSONArray encodeAllLottos(List<List<LottoNumber>> allLottoNumbers) {
        return new JSONArray(allLottoNumbers.stream().map(this::encodeLottoNumbers).toArray());
    }

    private String encodeLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::value)
                .map(String::valueOf)
                .collect(joining(","));
    }


}
