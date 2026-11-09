package me.gimmesomepeace.anishelf.app.feature.search.list.component

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId
import me.gimmesomepeace.anishelf.app.feature.search.list.model.AnimeListItem

@Composable
fun AnimeCard(
    anime: AnimeListItem,
    onClick: (AnimeId) -> Unit,
) {
    Card(onClick = { onClick(anime.id) }) {

    }
}
