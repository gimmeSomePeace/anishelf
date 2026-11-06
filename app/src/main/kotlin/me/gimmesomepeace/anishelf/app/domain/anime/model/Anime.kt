package me.gimmesomepeace.anishelf.app.domain.anime.model

import me.gimmesomepeace.anishelf.app.domain.genre.model.Genre

class Anime(
    val id: AnimeId,
    val title: String,

    val poster: AnimePoster?,
    val trailer: AnimeTrailer?,

    val status: AnimeStatus,
    val type: AnimeType,

    val synopsis: String,

    val score: Float?,
    val rank: Int?,
    val rating: AnimeRating,

    val episodes: Int?,

    val genres: List<Genre>,
) {
    init {
        require(title.isNotBlank()) { "Заголовок аниме не должен быть пустым." }
    }
}
