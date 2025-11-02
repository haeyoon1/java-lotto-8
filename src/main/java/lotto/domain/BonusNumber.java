package lotto.domain;

import lotto.ErrorMessage;

public class BonusNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public BonusNumber(String bonusNumberInput, Lotto winningLotto) {
        validateNumericString(bonusNumberInput);

        int bonusNumber = Integer.parseInt(bonusNumberInput);
        validateLottoNumber(bonusNumber);
        validateDuplicate(bonusNumber, winningLotto);

        this.number = bonusNumber;
    }

    private static void validateNumericString(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER_FORMAT.getValue());
        }
    }

    private void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT.getValue());
        }
    }

    private void validateDuplicate(int number, Lotto winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_LOTTO_NUMBER.getValue());
        }
    }

    public int getNumber() {
        return number;
    }
}
