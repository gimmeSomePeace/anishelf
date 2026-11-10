package me.gimmesomepeace.anishelf.app.feature.search.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId

@Composable
fun AnimeListRoute(
    onAnimeClick: (AnimeId) -> Unit,
    onGoToFilters: () -> Unit,
    viewModel: AnimeListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    AnimeListScreen(
        state = uiState,
        onAnimeClick = onAnimeClick,
        onAction = viewModel::onAction,
        onGoToFilters = onGoToFilters,
    )
}
