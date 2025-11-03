package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("유효한 금액 입력 시 올바른 로또 개수가 계산된다.")
    void 유효한_금액_입력_시_올바른_로또_개수가_계산된다() {
        Money money = new Money("8000");

        assertThat(money.getLottoCount()).isEqualTo(8);
    }

    @Test
    @DisplayName("숫자가 아닌 구입금액이 입력되면 예외가 발생한다.")
    void 숫자가_아닌_구입금액이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money("aaa"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_INPUT_NUMBER_FORMAT.getValue());
    }

    @Test
    @DisplayName("0 이하의 구입금액이 입력되면 예외가 발생한다.")
    void 구입금액이_0_이하이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_MONEY_RANGE.getValue());
    }

    @Test
    @DisplayName("1000원 단위가 아닌 구입금액이 입력되면 예외가 발생한다.")
    void 구입금액의_단위가_1000원이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money("5500"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_MONEY_UNIT.getValue());
    }
}