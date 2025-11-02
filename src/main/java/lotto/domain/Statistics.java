package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private static final int MIN_MATCH_COUNT = 3;
    private Map<WinningRank, Integer> statistics = new HashMap<>();

    public Statistics() {
        for (WinningRank winningRank : WinningRank.values()){
            statistics.put(winningRank, 0);
        }
    }

    public void updateStatistics(int matchCount, boolean isBonusMatch){
        if (matchCount < MIN_MATCH_COUNT){
            return;
        }
        WinningRank winningRank = WinningRank.findWinningRank(matchCount, isBonusMatch);
        statistics.put(winningRank, statistics.get(winningRank)+1);
    }

    public int getCountof(WinningRank winningRank) {
        return statistics.getOrDefault(winningRank, 0);
    }
}
