package me.gimmesomepeace.anishelf.app.feature.details

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AnimeDetailsViewModel : ViewModel() {
    private val _state = MutableStateFlow(AnimeDetailsState())
    val state = _state.asStateFlow()
}
