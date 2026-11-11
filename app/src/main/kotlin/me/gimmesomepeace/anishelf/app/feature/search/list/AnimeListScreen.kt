package me.gimmesomepeace.anishelf.app.feature.search.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId
import me.gimmesomepeace.anishelf.app.feature.search.list.component.AnimeCard
import me.gimmesomepeace.anishelf.app.feature.search.list.component.FiltersBar

@Composable
fun AnimeListScreen(
    state: AnimeListState,
    onAnimeClick: (AnimeId) -> Unit,
    onGoToFilters: () -> Unit,
    onAction: (AnimeListAction) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item(key = "filters_bar", contentType = { "filters_bar" }, span = { GridItemSpan(maxLineSpan) }) {
            FiltersBar(
                appliedFilters = state.appliedFilters,
                appliedSorting = state.appliedSorting,
                onAction = onAction,
                onFiltersButtonClicked = onGoToFilters,
            )
        }

        items(state.items, key = { it.id.value }, contentType = { it::class }) { anime ->
            AnimeCard(anime, onAnimeClick)
        }
    }
}
