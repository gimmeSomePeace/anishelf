package me.gimmesomepeace.anishelf.app.feature.search.filters

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AnimeFiltersViewModel : ViewModel() {
    private val _state = MutableStateFlow(AnimeFiltersState())
    val state = _state.asStateFlow()
}
