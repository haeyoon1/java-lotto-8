package lotto.domain;

public enum Prize {
    THREE_MATCH(3, 5000),
    FOUR_NATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_AND_BONUS_MATCH(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final long prize;

    Prize(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }
}
