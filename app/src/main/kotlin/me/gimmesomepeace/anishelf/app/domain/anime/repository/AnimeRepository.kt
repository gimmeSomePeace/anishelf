package me.gimmesomepeace.anishelf.app.domain.anime.repository

import me.gimmesomepeace.anishelf.app.domain.anime.model.Anime
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId
import me.gimmesomepeace.anishelf.app.domain.anime.model.Genre
import me.gimmesomepeace.anishelf.app.domain.common.Page
import me.gimmesomepeace.anishelf.app.domain.common.PageRequest

interface AnimeRepository {
    /**
     * @throws me.gimmesomepeace.anishelf.app.domain.anime.exception.AnimeException.AnimeNotFoundException
     */
    suspend fun getById(id: AnimeId): Anime

    suspend fun searchAnime(
        request: PageRequest,
        filters: AnimeFilters?,
        sorting: AnimeSorting?,
    ): Page<Anime>

    suspend fun getAvailableGenres(): List<Genre>
}
