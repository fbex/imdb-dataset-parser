package io.fbex.imdb.dataset.parser

import java.io.Reader

interface DatasetParser<out T> {
    fun parse(input: Reader): T
}
