package io.fbex.imdb.dataset.parser

import io.fbex.imdb.dataset.model.TitleBasic
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class TitleBasicsParserTests {

    private val testee = TitleBasicsParser()

    @Test fun `maps title basic correctly`() {
        val input = javaClass.getResourceAsStream("/dataset/title.basic.tsv").reader()
        val result = testee.parse(input)

        assertThat(result).hasSize(50)
        assertThat(result.first()).isEqualToComparingFieldByField(
                TitleBasic(
                        tconst = "tt0000001",
                        titleType = "short",
                        primaryTitle = "Carmencita",
                        originalTitle = "Carmencita",
                        isAdult = false,
                        startYear = 1894,
                        endYear = null,
                        runtimeMinutes = 1,
                        genres = listOf("Documentary", "Short")
                )
        )
    }
}
