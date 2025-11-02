package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Statistics;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Money money = readMoney();

        int lottoCount = money.getLottoCount();
        Lottos lottos = Lottos.generateLottos(lottoCount);
        OutputView.printLottos(lottos);

        Lotto winningLotto = readLotto();
        BonusNumber bonusNumber = readBonusLottoNumber(winningLotto);

        Statistics matchCount = generateStatistics(lottos, bonusNumber, winningLotto);

        Long totalPrize = Statistics.calculateTotalPrize(matchCount);
        OutputView.printTotalReturn(totalPrize, money);
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

    private Statistics generateStatistics(Lottos lottos, BonusNumber bonusNumber, Lotto winningLotto) {
        Statistics statistics = new Statistics();

        return statistics;
    }
}
