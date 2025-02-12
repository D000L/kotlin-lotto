package lotto

import lotto.domain.Grade
import lotto.domain.LottoResult
import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `당첨된 로또의 상금 합을 구한다`() {
        val result = LottoResult(Money(0), listOf(Grade.First, Grade.Second))
        val expect = Grade.First.reward + Grade.Second.reward
        Assertions.assertThat(result.totalReward).isEqualTo(expect)
    }

    @Test
    fun `당첨된 로또의 수익률을 구한다`() {
        val result = LottoResult(Money(5000), listOf(Grade.Five, Grade.Five))

        // 5등의 상금은 5_000 이다
        // 기대 수익률은 5000 * 2 / 5000 => 2f 이다.
        val expect = 2f
        Assertions.assertThat(result.revenueRate).isEqualTo(expect)
    }
}
