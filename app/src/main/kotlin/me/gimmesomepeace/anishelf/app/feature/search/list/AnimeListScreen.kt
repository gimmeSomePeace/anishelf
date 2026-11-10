package me.gimmesomepeace.anishelf.app.feature.search.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
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
    LazyColumn {
        item(key = "filters_bar", contentType = { "filters_bar" }) {
            FiltersBar(
                state = state,
                onAction = onAction,
                onFiltersButtonClicked = onGoToFilters,
            )
        }

        items(state.items, key = { it.id }, contentType = { it::class }) { anime ->
            AnimeCard(anime, onAnimeClick)
        }
    }
}
