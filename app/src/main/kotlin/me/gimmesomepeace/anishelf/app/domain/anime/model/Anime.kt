package me.gimmesomepeace.anishelf.app.domain.anime.model

import me.gimmesomepeace.anishelf.app.domain.common.ImageUri
import java.time.LocalDate

class Anime(
    val id: AnimeId,
    val title: String,
    val description: String,

    val poster: PosterImages,
    val banner: ImageUri?,
    val trailer: Trailer,

    val genres: List<Genre>,

    val status: AnimeStatus?,
    val format: AnimeFormat?,

    val episodes: Int?,
    val duration: Int?,
    val popularity: Int?,
    val score: Int?,

    val startDate: LocalDate?,
    val endDate: LocalDate?,
) {
    init {
        require(title.isNotBlank()) { "Название аниме не должно быть пустым." }
    }
}
