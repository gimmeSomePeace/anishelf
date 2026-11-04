package me.gimmesomepeace.anishelf.app.domain.genre

import java.net.URI

class Genre(
    val id: GenreId,
    val name: String,
    val uri: URI,
) {
    init {
        require(name.isNotBlank()) { "Название жанра не должно быть пустым" }
    }
}
