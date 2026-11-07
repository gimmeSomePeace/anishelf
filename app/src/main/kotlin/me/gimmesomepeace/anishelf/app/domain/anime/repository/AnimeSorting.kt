package me.gimmesomepeace.anishelf.app.domain.anime.repository

import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeSortField
import me.gimmesomepeace.anishelf.app.domain.common.SortDirection

data class AnimeSorting(
    val sortBy: AnimeSortField,
    val sortDirection: SortDirection,
)
