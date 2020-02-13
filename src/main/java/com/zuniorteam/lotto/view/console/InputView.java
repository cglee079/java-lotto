package com.zuniorteam.lotto.view.console;

import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public Integer scanMoney() {
        System.out.println("구입금액을 입력해주세요.");
        return SCANNER.nextInt();
    }

    public List<LottoNumber> scanWinNumber() {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        //TODO
        //
        SCANNER.nextLine();
        final String s = SCANNER.nextLine();

        return Arrays.stream(s.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
