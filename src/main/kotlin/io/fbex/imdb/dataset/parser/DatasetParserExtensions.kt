package io.fbex.imdb.dataset.parser

fun String.toBoolean(): Boolean {
    return this.toInt() == 1
}

fun String.toNullableInt(): Int? {
    if (this == "\\N") return null
    return this.toInt()
}
