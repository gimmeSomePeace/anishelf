package me.gimmesomepeace.anishelf.app.feature.search.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId
import me.gimmesomepeace.anishelf.app.feature.search.list.component.AnimeCard
import me.gimmesomepeace.anishelf.app.feature.search.list.component.SearchBar

@Composable
fun AnimeListScreen(
    state: AnimeListState,
    onAnimeClick: (AnimeId) -> Unit,
    onAction: (AnimeListAction) -> Unit,
) {
    LazyColumn {
        item(key = "search_bar", contentType = { "search_bar" }) {
            SearchBar(onSearchChanged = { onAction(AnimeListAction.QueryChangedAction(it)) })
        }

        items(state.items, key = { it.id }, contentType = { it::class }) { anime ->
            AnimeCard(anime, onAnimeClick)
        }
    }
}
