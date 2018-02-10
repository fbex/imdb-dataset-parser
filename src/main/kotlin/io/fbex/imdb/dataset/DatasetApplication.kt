package io.fbex.imdb.dataset

import io.fbex.imdb.dataset.parser.TitleBasicsParser
import io.fbex.imdb.dataset.parser.TitleRatingsParser
import java.io.FileReader

/**
 * Demo class to parse provided data sets.
 * Takes the file path as first parameter and
 * the data set type as second parameter.
 *
 * Valid types are:
 *  - basics
 *  - ratings
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val type = args[1]
    val fileReader = FileReader(filePath).buffered()

    println("Parsing file $filePath")
    if (type == "basics") {
        TitleBasicsParser().parse(fileReader)
    } else if (type == "ratings") {
        TitleRatingsParser().parse(fileReader)
    }
}
