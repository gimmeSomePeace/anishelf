package me.gimmesomepeace.anishelf.app.feature.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AnimeDetailsRoute(viewModel: AnimeDetailsViewModel = viewModel()) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    AnimeDetailsScreen(state = uiState)
}
