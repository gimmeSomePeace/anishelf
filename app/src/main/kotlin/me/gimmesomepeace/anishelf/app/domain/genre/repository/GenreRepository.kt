package me.gimmesomepeace.anishelf.app.domain.genre.repository

import me.gimmesomepeace.anishelf.app.domain.genre.model.Genre
import me.gimmesomepeace.anishelf.app.domain.genre.model.GenreType

interface GenreRepository {
    suspend fun getGenres(type: GenreType?): List<Genre>
}
