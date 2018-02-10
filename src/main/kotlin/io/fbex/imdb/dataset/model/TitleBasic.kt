package io.fbex.imdb.dataset.model

data class TitleBasic(
        val tconst: String,
        val titleType: String,
        val primaryTitle: String,
        val originalTitle: String,
        val isAdult: Boolean,
        val startYear: Int,
        val endYear: Int?,
        val runtimeMinutes: Int?,
        val genres: List<String>
)
