package lotto.view;

import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class OutputView {

    private static String LOTTO_PRINT_MESSAGE = "%d개를 구매했습니다.\n";
    private static String WINNING_STATISTICS = "당첨 통계\n" + "---";
    private static String MATCH_RESULT_FORMAT = "%d개 일치 (%,d원) - %d개\n";
    private static String BONUS_MATCH_RESULT_FORMAT = "%d개 일치 (%,d원) - %d개\n";
    private static String TOTAL_RETURN = "총 수익률은 %.1f입니다.";


    public static void printLottos(Lottos lottos) {
        System.out.printf(LOTTO_PRINT_MESSAGE, lottos.size());
        System.out.println(lottos);
    }

    public static void printWinningStatistics(Map<Prize, Integer> matchCount) {
        System.out.println(WINNING_STATISTICS);

    }

    public static void printTotalReturn(int totalPrize, int purchasePrice) {
        System.out.printf(TOTAL_RETURN, (totalPrize / purchasePrice) * 100);

    }

}
