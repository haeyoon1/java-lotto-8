package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.error.ErrorMessage;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_LOTTO_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);

        String input = Console.readLine();
        validateInputString(input);
        return input;
    }

    public static String inputWinningLotto() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);

        String input = Console.readLine();
        validateInputString(input);
        return input;
    }

    public static String inputBonusLottoNumber() {
        System.out.println();
        System.out.println(BONUS_LOTTO_INPUT_MESSAGE);

        String input = Console.readLine();
        validateInputString(input);
        return input;
    }

    private static void validateInputString(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getValue());
        }
    }
}
