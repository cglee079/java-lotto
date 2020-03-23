package com.zuniorteam.lotto.web.route;

import com.zuniorteam.lotto.core.*;
import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.render.InputRender;
import com.zuniorteam.lotto.vo.LottoNumber;
import com.zuniorteam.lotto.vo.Money;
import org.json.JSONArray;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;

import static com.zuniorteam.lotto.web.render.TemplateEngine.render;
import static java.util.stream.Collectors.toList;

public class PostMatchLottoRoute implements Route {

    private static final String PARAM_INPUT_MONEY = "inputMoney";
    private static final String PARAM_BUY_LOTTOS = "buyLottos";
    private static final String PARAM_BONUS_NUMBER = "bonusNumber";
    private static final String PARAM_WINNING_NUMBER = "winningNumber";
    private static final String VIEW_NAME = "result";

    private final LottoOffice lottoOffice = new LottoOffice();

    @Override
    public Object handle(Request request, Response response) {
        final Money insertedMoney = InputRender.getInsertMoney(getInputMoney(request));
        final Lottos buyLottos = InputRender.getLottos(getBuyLottos(request));

        final Lotto winningNumber = InputRender.getWinningLotto(getWinningNumber(request));
        final LottoNumber bonusNumber = InputRender.getBonusNumber(getBonusNumber(request));

        final LottoResult lottoResult = lottoOffice.getLottoResult(new LottoBuyer(insertedMoney, buyLottos), new WinningLotto(winningNumber, bonusNumber));

        final HashMap<String, Object> model = new HashMap<>();
        model.put("lottoResult", lottoResult);

        return render(model, VIEW_NAME);
    }

    private Integer getBonusNumber(Request request) {
        return Integer.valueOf(request.queryParams(PARAM_BONUS_NUMBER));
    }

    private String getWinningNumber(Request request) {
        return request.queryParams(PARAM_WINNING_NUMBER);
    }

    private List<String> getBuyLottos(Request request) {
        return new JSONArray(request.queryParams(PARAM_BUY_LOTTOS)).toList().stream()
                .map(Object::toString)
                .collect(toList());
    }

    private Integer getInputMoney(Request request) {
        return Integer.valueOf(request.queryParams(PARAM_INPUT_MONEY));
    }
}
