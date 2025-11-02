package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Statistics;
import lotto.domain.WinningRank;

public class OutputView {

    private static String LOTTO_PRINT_MESSAGE = "%d개를 구매했습니다.\n";
    private static String WINNING_STATISTICS = "당첨 통계\n" + "---";
    private static String MATCH_RESULT_FORMAT = "%d개 일치 (%,d원) - %d개\n";
    private static String BONUS_MATCH_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static String TOTAL_RETURN = "총 수익률은 %.1f입니다.";


    public static void printLottos(Lottos lottos) {
        System.out.println();
        System.out.printf(LOTTO_PRINT_MESSAGE, lottos.size());

        System.out.println(lottos);
    }

    public static void printWinningStatistics(Statistics statistics) {
        System.out.println(WINNING_STATISTICS);

        for (WinningRank winningRank: WinningRank.values()){
            int count = statistics.getCountof(winningRank);

            if (winningRank == WinningRank.FIVE_AND_BONUS_MATCH){
                System.out.printf(BONUS_MATCH_RESULT_FORMAT, winningRank.getMatchCount(), winningRank.getPrize(), count);
                continue;
            }
            System.out.printf(MATCH_RESULT_FORMAT, winningRank.getMatchCount(), winningRank.getPrize(), count);
        }
    }

    public static void printTotalReturn(Long totalPrize, Money purchasePrice) {
        System.out.printf(TOTAL_RETURN, (totalPrize / purchasePrice.getAmount()) * 100);
    }

}
