package com.zuniorteam.lotto.view.console;

import java.util.Scanner;

public class InputView {

    private final Scanner SCANNER = new Scanner(System.in);

    public Integer scanMoney() {
        System.out.println("구입금액을 입력해주세요.");

        final int insertedMoney = SCANNER.nextInt();
        SCANNER.nextLine();

        return insertedMoney;
    }

    public int scanBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");

        final int bonusNumber = SCANNER.nextInt();
        SCANNER.nextLine();

        return bonusNumber;

    }

    public String scanWinningNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요. ex) 1,2,3,4,5,6");

        return SCANNER.nextLine();

    }
}
