package me.gimmesomepeace.anishelf.app.feature.list

import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeFormat
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeStatus
import me.gimmesomepeace.anishelf.app.domain.anime.model.Genre
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeSorting

sealed interface AnimeListAction {
    data class QueryChangedAction(
        val newQuery: String,
    ) : AnimeListAction

    data class StatusRemovedAction(
        val removedStatus: AnimeStatus,
    ) : AnimeListAction

    data class FormatRemovedAction(
        val removedFormat: AnimeFormat,
    ) : AnimeListAction

    data class GenreRemovedAction(
        val removedGenre: Genre,
    ) : AnimeListAction

    data class SortingChanged(
        val newSorting: AnimeSorting,
    ) : AnimeListAction

    data object LoadNextPageAction : AnimeListAction
}
