package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("입력한 개수만큼 로또가 생성된다.")
    void 입력한_개수만큼_로또가_생성된다() {
        // given
        int count = 5;

        // when
        Lottos lottos = Lottos.generateLottos(count);

        // then
        assertThat(lottos.getLottos()).hasSize(count);
    }
}