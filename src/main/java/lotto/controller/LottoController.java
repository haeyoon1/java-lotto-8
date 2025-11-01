package lotto.controller;

import java.util.List;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.Money;
import lotto.Parser;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        Money money = readMoney();

        Lotto winningLotto = readLotto();
        BonusNumber bonusNumber = readBonusLottoNumber(winningLotto);
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
        while (true) {
            try {
                String lotto = InputView.inputWinningLotto();

                Parser parse = new Parser();
                List<Integer> lottoNumbers = parse.parseToLotto(lotto);

                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private BonusNumber readBonusLottoNumber(Lotto winningLotto) {
        while (true) {
            try {
                String lottoNumber = InputView.inputBonusLottoNumber();

                return new BonusNumber(lottoNumber, winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
