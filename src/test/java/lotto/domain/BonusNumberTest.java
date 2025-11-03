package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("유효한 보너스 번호 입력 시 올바르게 저장된다.")
    void 유효한_보너스_번호_입력시_정상_저장한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonus = new BonusNumber("7", winningLotto);

        assertThat(bonus.getNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("숫자가 아닌 보너스 번호 입력 시 예외가 발생한다.")
    void 숫자가_아닌_보너스_번호가_입력되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber("aaa", winningLotto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_INPUT_NUMBER_FORMAT.getValue());
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    void 보너스_번호가_1이상_45이하가_아니면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber("0", winningLotto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT.getValue());

        assertThatThrownBy(() -> new BonusNumber("46", winningLotto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT.getValue());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void 보너스_번호와_당첨_번호가_중복되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber("3", winningLotto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.DUPLICATE_BONUS_LOTTO_NUMBER.getValue());
    }
}