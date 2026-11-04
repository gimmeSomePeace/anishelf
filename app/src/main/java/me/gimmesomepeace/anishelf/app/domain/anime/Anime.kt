package me.gimmesomepeace.anishelf.app.domain.anime

import me.gimmesomepeace.anishelf.app.domain.genre.Genre

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
    val episodes: Int?,

    val genres: List<Genre>,
) {
    init {
        require(title.isNotBlank()) { "Заголовок аниме не должен быть пустым." }
    }
}
