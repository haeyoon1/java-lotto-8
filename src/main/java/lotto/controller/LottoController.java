package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public void run() {
        int money = InputView.inputMoney();

        String winningLotto = InputView.inputWinningLotto();

        String bonusNumber = InputView.inputBonusLottoNumber();
    }

}
