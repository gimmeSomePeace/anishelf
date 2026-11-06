package me.gimmesomepeace.anishelf.app.domain.anime.repository

import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeFormat
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeStatus
import me.gimmesomepeace.anishelf.app.domain.anime.model.Genre
import java.time.LocalDate

data class AnimeFilters(
    val query: String? = null,
    val minScore: Int? = null,
    val maxScore: Int? = null,

    val statusIn: Set<AnimeStatus> = emptySet(),
    val formatIn: Set<AnimeFormat> = emptySet(),
    val genreIn: Set<Genre> = emptySet(),

    val minStartDate: LocalDate? = null,
    val maxStartDate: LocalDate? = null,
    val minEndDate: LocalDate? = null,
    val maxEndDate: LocalDate? = null,
) {
    init {
        require(query == null || query.isNotBlank()) {
            "Если поисковый запрос задан, он должен содержать хотя бы один непробельный символ"
        }

        require(minScore == null || minScore in 0..100) {
            "Значение минимальной оценки должно быть в пределах от 0 до 100. Получено: $minScore"
        }

        require(maxScore == null || maxScore in 0..100) {
            "Значение максимальной оценки должно быть в пределах от 0 до 100. Получено: $maxScore"
        }

        require(minScore == null || maxScore == null || minScore <= maxScore) {
            "Значение минимального рейтинга не должно превосходить значение максимального рейтинга. Получено: $minScore <= $maxScore"
        }

        require(minStartDate == null || maxStartDate == null || minStartDate <= maxStartDate) {
            "Значение минимальной даты выпуска не должно превосходить значение максимальной даты выпуска. Получено: $minStartDate <= $maxStartDate"
        }

        require(minEndDate == null || maxEndDate == null || minEndDate <= maxEndDate) {
            "Значение минимальной даты окончания не должно превосходить значение максимальной даты окончания. Получено: $minEndDate <= $maxEndDate"
        }
    }
}
