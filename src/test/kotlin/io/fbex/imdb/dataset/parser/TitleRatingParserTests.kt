package io.fbex.imdb.dataset.parser

import io.fbex.imdb.dataset.model.TitleRating
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class TitleRatingParserTests {

    private val testee = TitleRatingsParser()

    @Test fun `maps title ratings correctly`() {
        val input = javaClass.getResourceAsStream("/dataset/title.ratings.tsv").reader()
        val result = testee.parse(input)

        assertThat(result).hasSize(100)
        assertThat(result.first()).isEqualToComparingFieldByField(
                TitleRating(
                        tconst = "tt0000001",
                        averageRating = 5.8,
                        numVotes = 1349
                )
        )
    }
}
