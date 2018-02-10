package io.fbex.imdb.dataset.parser

import io.fbex.imdb.dataset.model.TitleRating
import org.apache.commons.csv.CSVFormat
import java.io.Reader

class TitleRatingsParser : DatasetParser<List<TitleRating>> {

    private enum class Headers {
        tconst, averageRating, numVotes
    }

    override fun parse(input: Reader): List<TitleRating> {
        val records = CSVFormat.TDF.withHeader(Headers::class.java).parse(input)

        records.first() // skip header
        return records.map {
            val titleRating = TitleRating(
                    tconst = it.get(Headers.tconst),
                    averageRating = it.get(Headers.averageRating).toDouble(),
                    numVotes = it.get(Headers.numVotes).toInt()
            )
            println(titleRating)
            titleRating
        }.toList()
    }
}
