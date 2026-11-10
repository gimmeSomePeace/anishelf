package me.gimmesomepeace.anishelf.app.feature.search.list.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import me.gimmesomepeace.anishelf.R
import me.gimmesomepeace.anishelf.app.feature.search.list.AnimeListAction
import me.gimmesomepeace.anishelf.app.feature.search.list.AnimeListState

@Composable
fun FiltersBar(
    state: AnimeListState,
    onAction: (AnimeListAction) -> Unit,
    onFiltersButtonClicked: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SearchBar(
            state.appliedFilters.query.orEmpty(),
            onSearchChanged = { onAction(AnimeListAction.QueryChangedAction(it)) },
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onFiltersButtonClicked) {
                Icon(
                    painter = painterResource(R.drawable.filters),
                    contentDescription = "Фильтры",
                )
            }
            // TODO: insert some pop up
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.sort),
                    contentDescription = "Сортировка",
                )
            }
        }
        ChipsBar(state.appliedFilters, onAction)
    }
}
