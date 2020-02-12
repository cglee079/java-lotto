package com.zuniorteam.lotto;

import com.zuniorteam.lotto.core.LottoGenerator;
import com.zuniorteam.lotto.core.LottoOffice;
import com.zuniorteam.lotto.vo.Lotto;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        final LottoGenerator lottoGenerator = new LottoGenerator();

        final LottoOffice lottoOffice = new LottoOffice(lottoGenerator);

        final List<Lotto> buy = lottoOffice.buy(10000);

        for (Lotto lotto : buy) {
            System.out.println(lotto);
        }


    }
}
