package me.gimmesomepeace.anishelf.app.domain.anime.model

data class Genre(
    val name: String,
) {
    init {
        require(name.isNotBlank()) { "Наименование жанра не должно быть пустым." }
    }
}
