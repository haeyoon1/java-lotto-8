package lotto.domain;

public enum WinningRank {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_AND_BONUS_MATCH(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final long prize;

    WinningRank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static WinningRank findWinningRank(int matchCount, boolean isBonusMatch) {
        if (matchCount == 3) return THREE_MATCH;
        if (matchCount == 4) return FOUR_MATCH;
        if ((matchCount == 5) && isBonusMatch) return FIVE_AND_BONUS_MATCH;
        if (matchCount == 5) return FIVE_MATCH;
        if (matchCount == 6) return SIX_MATCH;
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }
}
