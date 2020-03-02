package com.zuniorteam.lotto.vo;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(int value) {
        validate(value);

        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("로또 숫자는" + MIN_VALUE + " 보다 작을 수 없습니다 : " + value);
        }

        if (value > MAX_VALUE) {
            throw new IllegalArgumentException("로또 숫자는" + MAX_VALUE + " 보다 클 수 없습니다 : " + value);
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
