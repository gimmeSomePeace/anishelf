package me.gimmesomepeace.anishelf.app.domain.anime.repository

import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeRating
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeStatus
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeType
import me.gimmesomepeace.anishelf.app.domain.common.OrderBy
import me.gimmesomepeace.anishelf.app.domain.common.Sort
import me.gimmesomepeace.anishelf.app.domain.genre.model.GenreId
import java.time.LocalDate

data class AnimeFilters(
    val query: String? = null,
    val type: AnimeType? = null,
    val minScore: Double? = null,
    val maxScore: Double? = null,
    val status: AnimeStatus? = null,

    val rating: AnimeRating? = null,
    val genresIds: Set<GenreId> = emptySet(),
    val orderBy: OrderBy? = null,
    val sort: Sort? = null,

    val startDate: LocalDate? = null,
    val endDate: LocalDate? = null,
) {
    init {
        require(query == null || query.isNotBlank()) {
            "Если поисковый запрос задан, он должен содержать хотя бы один непробельный символ"
        }

        require(minScore == null || maxScore == null || minScore <= maxScore) {
            "Значение минимального рейтинга не должно превосходить значение максимального рейтинга. Получено: $minScore <= $maxScore"
        }

        require(startDate == null || endDate == null || startDate <= endDate) {
            "Значение минимальной даты выпуска не должно превосходить значение максимальной даты выпуска. Получено: $startDate <= $endDate"
        }
    }
}
