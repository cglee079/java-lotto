package com.zuniorteam.lotto.view.console;

import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.dto.MatchResult;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.List;

public class OutputView {

    public void printLottos(List<List<LottoNumber>> lottos) {
        for (List<LottoNumber> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨결과");

        for (MatchResult matchResult : lottoResult.getMatchResults()) {
            final String prizeRuleInfo = getPrizeRuleOutput(matchResult);
            final String prizeMoneyOutput = getPrizeMoney(matchResult.getPrizeMoney());
            System.out.println(prizeRuleInfo + " " + prizeMoneyOutput + " - " + matchResult.getLottoCount());
        }

        System.out.println("---------------");
        System.out.println(String.format("승률 %.2f", lottoResult.getWinPercent()));

    }

    private String getPrizeRuleOutput(MatchResult matchResult) {
        return String.format("%s개 %s", matchResult.getMatchCount(), matchResult.getHasBonus() ? "보너스볼 포함" : "");
    }

    private String getPrizeMoney(Long prizeMoney) {
        return String.format("(%,d원)", prizeMoney);
    }
}
