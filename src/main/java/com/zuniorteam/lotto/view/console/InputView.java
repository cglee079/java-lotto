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
        final int insertedMoney = SCANNER.nextInt();

        SCANNER.nextLine();

        return insertedMoney;
    }

    public List<LottoNumber> scanWinningNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요. ex) 1,2,3,4,5,6");

        final String line = SCANNER.nextLine();

        return Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
