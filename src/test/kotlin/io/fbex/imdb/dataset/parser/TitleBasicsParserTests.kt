package io.fbex.imdb.dataset.parser

import io.fbex.imdb.dataset.model.TitleBasic
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class TitleBasicsParserTests {

    private val testee = TitleBasicsParser()

    @Test fun `maps title basic correctly`() {
        val input = javaClass.getResourceAsStream("/dataset/title.basic.tsv").reader()
        val result = testee.parse(input)

        assertThat(result).hasSize(52)
        assertThat(result.first()).isEqualToComparingFieldByField(
                TitleBasic(
                        tconst = "tt0000001",
                        titleType = "short",
                        primaryTitle = "Carmencita",
                        originalTitle = "Carmencita",
                        isAdult = false,
                        startYear = 1894,
                        endYear = null,
                        runtimeMinutes = null,
                        genres = listOf("Documentary", "Short")
                ))
        assertThat(result[50]).isEqualToComparingFieldByField(
                TitleBasic(
                        tconst = "tt0067098",
                        titleType = "tvEpisode",
                        primaryTitle = "Willi Forst",
                        originalTitle = "Willi Forst",
                        isAdult = false,
                        startYear = null,
                        endYear = null,
                        runtimeMinutes = 55,
                        genres = null))
        assertThat(result[51]).isEqualToComparingFieldByField(
                TitleBasic(
                        tconst = "tt0544863",
                        titleType = "tvEpisode",
                        primaryTitle = "\"Consuela\" (Or 'The New Mrs Saunders')",
                        originalTitle = "\"Consuela\" (Or 'The New Mrs Saunders')",
                        isAdult = false,
                        startYear = 1986,
                        endYear = null,
                        runtimeMinutes = 36,
                        genres = listOf("Comedy"))
        )
    }
}
