package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StatisticsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 0, -1})
    @DisplayName("로또 번호가 3개 미만 일치 시 통계에 포함되지 않는다.")
    void 일치한_로또_번호의_개수가_3_미만일시_저장되지_않는다(int matchCount) {
        // given
        Statistics statistics = new Statistics();

        // when
        statistics.updateStatistics(matchCount, false);

        // then
        for (WinningRank rank : WinningRank.values()) {
            assertThat(statistics.getCountof(rank)).isZero();
        }
    }

    @Test
    @DisplayName("등수별 당첨된 로또의 개수를 정확하게 계산한다.")
    void 등수별_당첨_로또_개수의_카운트를_정확하게_계산한다() {
        // given
        Statistics statistics = new Statistics();

        // when
        statistics.updateStatistics(3, false);
        statistics.updateStatistics(5, false);
        statistics.updateStatistics(5, true);
        statistics.updateStatistics(3, false);

        // then
        assertThat(statistics.getCountof(WinningRank.THREE_MATCH)).isEqualTo(2);
        assertThat(statistics.getCountof(WinningRank.FIVE_MATCH)).isEqualTo(1);
        assertThat(statistics.getCountof(WinningRank.FIVE_AND_BONUS_MATCH)).isEqualTo(1);
    }

    @Test
    @DisplayName("통계 결과에 따라 총 상금을 정확하게 계산한다")
    void 통계_결과에_따른_총_상금을_정확하게_계산한다() {
        // given
        Statistics statistics = new Statistics();
        statistics.updateStatistics(3, false);
        statistics.updateStatistics(4, false);
        statistics.updateStatistics(5, false);

        long expectedPrize =
            WinningRank.THREE_MATCH.getPrize() + WinningRank.FOUR_NATCH.getPrize() + WinningRank.FIVE_MATCH.getPrize();

        // when
        long totalPrize = Statistics.calculateTotalPrize(statistics);

        // then
        assertThat(totalPrize).isEqualTo(expectedPrize);
    }
}