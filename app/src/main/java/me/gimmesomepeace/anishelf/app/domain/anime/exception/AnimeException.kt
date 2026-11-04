package me.gimmesomepeace.anishelf.app.domain.anime.exception

import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId

sealed class AnimeException(
    msg: String,
) : RuntimeException(msg) {
    class AnimeNotFoundException(
        val id: AnimeId,
    ) : AnimeException("Аниме с идентификатором ${id.value} не было найдено")
}
