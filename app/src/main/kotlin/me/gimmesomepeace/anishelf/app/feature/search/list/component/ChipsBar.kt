package me.gimmesomepeace.anishelf.app.feature.search.list.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeFilters
import me.gimmesomepeace.anishelf.app.feature.search.list.AnimeListAction

@Composable
fun ChipsBar(
    appliedFilters: AnimeFilters,
    onAction: (AnimeListAction) -> Unit,
) {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            appliedFilters.genreIn.forEach {
                ChipCard(
                    text = it.name,
                    onClick = { onAction(AnimeListAction.GenreRemovedAction(it)) },
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            appliedFilters.statusIn.forEach {
                ChipCard(
                    text = it.name,
                    onClick = { onAction(AnimeListAction.StatusRemovedAction(it)) },
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            appliedFilters.formatIn.forEach {
                ChipCard(
                    text = it.name,
                    onClick = { onAction(AnimeListAction.FormatRemovedAction(it)) },
                )
            }
        }
    }
}
