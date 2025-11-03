package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = new BonusNumber("7", winningNumbers);
    }

    @Test
    @DisplayName("6개 번호 모두 일치하면 1등을 반환한다.")
    void 여섯개_일치_시_1등() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        int matchCount = myLotto.matchCount(winningNumbers);
        boolean isBonusMatch = myLotto.matchBonusLotto(bonusNumber);
        WinningRank result = WinningRank.findWinningRank(matchCount, isBonusMatch);

        // then
        assertThat(result).isEqualTo(WinningRank.SIX_MATCH);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등을 반환한다.")
    void 다섯개_및_보너스_일치_시_2등() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        int matchCount = myLotto.matchCount(winningNumbers);
        boolean isBonusMatch = myLotto.matchBonusLotto(bonusNumber);
        WinningRank result = WinningRank.findWinningRank(matchCount, isBonusMatch);

        // then
        assertThat(result).isEqualTo(WinningRank.FIVE_AND_BONUS_MATCH);
    }

    @Test
    @DisplayName("5개 번호만 일치하면 3등을 반환한다.")
    void 다섯개만_일치_시_3등() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        // when
        int matchCount = myLotto.matchCount(winningNumbers);
        boolean isBonusMatch = myLotto.matchBonusLotto(bonusNumber);
        WinningRank result = WinningRank.findWinningRank(matchCount, isBonusMatch);

        // then
        assertThat(result).isEqualTo(WinningRank.FIVE_MATCH);
    }

    @Test
    @DisplayName("4개 번호 일치 시 4등을 반환한다.")
    void 네개_일치_시_4등() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));

        // when
        int matchCount = myLotto.matchCount(winningNumbers);
        boolean isBonusMatch = myLotto.matchBonusLotto(bonusNumber);
        WinningRank result = WinningRank.findWinningRank(matchCount, isBonusMatch);

        // then
        assertThat(result).isEqualTo(WinningRank.FOUR_MATCH);
    }

    @Test
    @DisplayName("3개 번호 일치 시 5등을 반환한다.")
    void 세개_일치_시_5등() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));

        // when
        int matchCount = myLotto.matchCount(winningNumbers);
        boolean isBonusMatch = myLotto.matchBonusLotto(bonusNumber);
        WinningRank result = WinningRank.findWinningRank(matchCount, isBonusMatch);

        // then
        assertThat(result).isEqualTo(WinningRank.THREE_MATCH);
    }
}