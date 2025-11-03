package lotto.domain;

import lotto.error.ErrorMessage;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public Money(String inputAmount) {
        validateNumericString(inputAmount);
        int money = Integer.parseInt(inputAmount);
        validateMoneyAmount(money);

        this.amount = money;
    }

    private static void validateNumericString(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER_FORMAT.getValue());
        }
    }

    private static void validateMoneyAmount(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_RANGE.getValue());
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT.getValue());
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
