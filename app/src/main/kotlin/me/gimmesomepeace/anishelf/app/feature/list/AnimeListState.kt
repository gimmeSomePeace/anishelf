package me.gimmesomepeace.anishelf.app.feature.list

import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeSortField
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeFilters
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeSorting
import me.gimmesomepeace.anishelf.app.domain.common.SortDirection
import me.gimmesomepeace.anishelf.app.feature.list.model.AnimeListItem

data class AnimeListState(
    val items: List<AnimeListItem> = emptyList(),
    val hasMorePages: Boolean = false,

    val appliedFilters: AnimeFilters = AnimeFilters(),
    val appliedSorting: AnimeSorting = AnimeSorting(
        sortBy = AnimeSortField.POPULARITY,
        sortDirection = SortDirection.DESC,
    ),

    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val errorMessage: String? = null,
)
