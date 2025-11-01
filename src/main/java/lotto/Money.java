package lotto;

public class Money {

    private final int amount;

    public Money(String inputAmount) {
        validateNumericString(inputAmount);
        int money = Integer.parseInt(inputAmount);
        validateMoneyUnit(money);

        this.amount = money;
    }

    private static void validateNumericString(String input) {
        if (!input.matches("\\d+")){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER_FORMAT.getValue());
        }
    }

    private static void validateMoneyUnit(int money) {
        if (money % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT.getValue());
        }
    }
}
