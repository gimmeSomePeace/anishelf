package me.gimmesomepeace.anishelf.app.data.anime.repository

import me.gimmesomepeace.anishelf.app.domain.anime.exception.AnimeException
import me.gimmesomepeace.anishelf.app.domain.anime.model.Anime
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId
import me.gimmesomepeace.anishelf.app.domain.anime.model.Genre
import me.gimmesomepeace.anishelf.app.domain.anime.model.PosterImages
import me.gimmesomepeace.anishelf.app.domain.anime.model.Trailer
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeFilters
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeRepository
import me.gimmesomepeace.anishelf.app.domain.common.Page
import me.gimmesomepeace.anishelf.app.domain.common.PageRequest
import java.util.concurrent.ConcurrentHashMap

class FakeAnimeRepository : AnimeRepository {
    private val items = ConcurrentHashMap(
        (1..100)
            .map {
                Anime(
                    id = AnimeId(it),
                    title = "Anime with id: $it",
                    description = "Some kind of description: $it",
                    poster = PosterImages(),
                    trailer = Trailer(),
                    genres = emptyList(),
                    banner = null,
                    status = null,
                    format = null,
                    episodes = null,
                    duration = null,
                    popularity = null,
                    score = null,
                    startDate = null,
                    endDate = null,
                )
            }.associateBy { it.id },
    )

    override suspend fun getById(id: AnimeId): Anime = items[id] ?: throw AnimeException.AnimeNotFoundException(id)

    override suspend fun searchAnime(
        request: PageRequest,
        filters: AnimeFilters,
    ): Page<Anime> {
        val responseItems = items.values.drop((request.pageNumber - 1) * request.limit).take(request.limit + 1)
        return Page(
            items = responseItems.take(request.limit),
            hasNext = responseItems.size > request.limit,
            currentPage = request.pageNumber,
        )
    }

    override suspend fun getAvailableGenres(): List<Genre> = (1..3).map { Genre(name = "Genre $it") }
}
