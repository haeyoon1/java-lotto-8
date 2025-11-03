package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private static final int MIN_MATCH_COUNT = 3;
    private static final int INITIAL_COUNT = 0;

    private final Map<WinningRank, Integer> statistics = new HashMap<>();

    public Statistics() {
        for (WinningRank winningRank : WinningRank.values()) {
            statistics.put(winningRank, INITIAL_COUNT);
        }
    }

    public void updateStatistics(int matchCount, boolean isBonusMatch) {
        if (matchCount < MIN_MATCH_COUNT) {
            return;
        }
        WinningRank winningRank = WinningRank.findWinningRank(matchCount, isBonusMatch);
        statistics.put(winningRank, statistics.get(winningRank) + 1);
    }

    public static long calculateTotalPrize(Statistics statistics) {
        long totalPrize = 0;

        for (WinningRank winningRank : WinningRank.values()) {
            totalPrize += statistics.getCountof(winningRank) * winningRank.getPrize();
        }
        return totalPrize;
    }

    public int getCountof(WinningRank winningRank) {
        return statistics.getOrDefault(winningRank, 0);
    }
}
