package me.gimmesomepeace.anishelf.app.feature.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId

@Composable
fun AnimeListRoute(
    onAnimeClick: (AnimeId) -> Unit,
    viewModel: AnimeListViewModel = viewModel(),
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    AnimeListScreen(
        state = uiState,
        onAnimeClick = onAnimeClick,
    )
}
