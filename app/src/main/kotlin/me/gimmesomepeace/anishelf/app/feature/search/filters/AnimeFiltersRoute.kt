package me.gimmesomepeace.anishelf.app.feature.search.filters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AnimeFiltersRoute(viewModel: AnimeFiltersViewModel = viewModel()) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    AnimeFiltersScreen(uiState)
}
