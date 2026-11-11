package me.gimmesomepeace.anishelf.app.feature.search.list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.gimmesomepeace.anishelf.R
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeFormat
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeSortField
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeStatus
import me.gimmesomepeace.anishelf.app.domain.anime.model.Genre
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeFilters
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeSorting
import me.gimmesomepeace.anishelf.app.domain.common.SortDirection
import me.gimmesomepeace.anishelf.app.feature.search.list.AnimeListAction

@Composable
fun FiltersBar(
    appliedFilters: AnimeFilters,
    appliedSorting: AnimeSorting,
    onAction: (AnimeListAction) -> Unit,
    onFiltersButtonClicked: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SearchBar(
            appliedFilters.query.orEmpty(),
            onSearchChanged = { onAction(AnimeListAction.QueryChangedAction(it)) },
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = onFiltersButtonClicked, modifier = Modifier.weight(1f)) {
                Icon(
                    painter = painterResource(R.drawable.filters),
                    contentDescription = null,
                )
                Text(text = stringResource(R.string.feature_search_list_filters_button))
            }
            // TODO: insert some pop up
            OutlinedButton(onClick = { }, modifier = Modifier.weight(1f)) {
                Icon(
                    painter = painterResource(R.drawable.sort),
                    contentDescription = null,
                )
                Text(text = stringResource(R.string.feature_search_list_sorting_button))
            }
        }
        ChipsBar(appliedFilters, onAction)
    }
}

@Composable
@Preview(showBackground = true)
private fun FiltersBarPreview() {
    FiltersBar(
        appliedFilters = AnimeFilters(
            query = "some long long long long text",
            statusIn = setOf(AnimeStatus.FINISHED, AnimeStatus.NOT_YET_RELEASED),
            genreIn = setOf(Genre(name = "Жанр 1"), Genre(name = "Жанр 2")),
            formatIn = setOf(AnimeFormat.ONE_SHOT, AnimeFormat.TV_SHORT),
        ),
        appliedSorting = AnimeSorting(
            sortBy = AnimeSortField.SCORE,
            sortDirection = SortDirection.DESC,
        ),
        onAction = {},
        onFiltersButtonClicked = {},
    )
}
