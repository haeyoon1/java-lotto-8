package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.Money;
import lotto.Parser;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        Money money = readMoney();

        Lotto winningLotto = readLotto();

        String bonusNumber = InputView.inputBonusLottoNumber();
    }

    private Money readMoney() {
        while (true) {
            try {
                String money = InputView.inputMoney();

                return new Money(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto readLotto() {

    }

    private static void validateLottoFormat(String input) {

    }


}
