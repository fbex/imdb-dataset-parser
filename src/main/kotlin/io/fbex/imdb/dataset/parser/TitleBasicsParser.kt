package io.fbex.imdb.dataset.parser

import io.fbex.imdb.dataset.model.TitleBasic
import org.apache.commons.csv.CSVFormat
import java.io.Reader

class TitleBasicsParser : DatasetParser<List<TitleBasic>> {

    private enum class Headers {
        tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres
    }

    override fun parse(input: Reader): List<TitleBasic> {
        val records = CSVFormat.TDF.withQuote(null).withHeader(Headers::class.java).parse(input)

        records.first() // skip header
        return records.map {
            val titleBasic = TitleBasic(
                    tconst = it.get(Headers.tconst),
                    titleType = it.get(Headers.titleType),
                    primaryTitle = it.get(Headers.primaryTitle),
                    originalTitle = it.get(Headers.originalTitle),
                    isAdult = it.get(Headers.isAdult).toBoolean(),
                    startYear = it.get(Headers.startYear).toNullableInt(),
                    endYear = it.get(Headers.endYear).toNullableInt(),
                    runtimeMinutes = it.get(Headers.runtimeMinutes).toNullableInt(),
                    genres = it.get(Headers.genres).toNullableList()
            )
            println(titleBasic)
            titleBasic
        }.toList()
    }
}
