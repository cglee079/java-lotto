package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.util.CollectionUtil;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        assert lottos != null;

        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(new ArrayList<>(lottos));
    }

    public List<List<LottoNumber>> getAllLottoNumbers() {
        final List<List<LottoNumber>> lottoNumbers = this.lottos.stream()
                .map(Lotto::getLottoNumbers)
                .collect(toList());

        return Collections.unmodifiableList(lottoNumbers);
    }

    public Lottos merge(Lottos autoLottos) {
        return new Lottos(CollectionUtil.merge(this.lottos, autoLottos.getLottos()));
    }

    public int size() {
        return lottos.size();
    }
}
