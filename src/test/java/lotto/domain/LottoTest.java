package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 6개의 로또 번호로 객체를 정상 생성한다.")
    @Test
    void 유효한_6개의_로또_번호로_객체를_정상_생성한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("당첨 번호와 일치하는 번호의 개수를 정확히 반환한다.")
    @Test
    void 당첨_번호와_일치하는_번호의_개수를_정확히_반환한다() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        int matchCount = myLotto.matchCount(winningLotto);

        assertThat(matchCount).isEqualTo(3);
    }
}
