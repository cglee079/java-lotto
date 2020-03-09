package com.zuniorteam.lotto.vo;

import java.util.Objects;

public class Money {

    public static final Money ZERO = Money.of(0);

    private long amount;

    private Money(Long money) {
        assert money != null;
        assert money >= 0;

        this.amount = money;
    }

    public static Money of(Integer money) {
        return new Money(money.longValue());
    }

    public static Money of(Long money) {
        return new Money(money);
    }

    public long amount() {
        return amount;
    }

    public Money add(Money money) {
        return Money.of(amount + money.amount);
    }

    public Money multiple(Integer count) {
        return Money.of(this.amount * count);
    }

    public Money divideMoney(Money money) {
        validateDivideMoney(money);
        return Money.of(amount / money.amount);
    }

    private void validateDivideMoney(Money money) {
        if (money.equals(Money.ZERO)) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }

        if ((amount != 0) && (amount % money.amount != 0)) {
            throw new IllegalArgumentException("금액이 나누어 떨어지지 않습니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

}
