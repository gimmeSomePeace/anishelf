package me.gimmesomepeace.anishelf.app.feature.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AnimeListViewModel : ViewModel() {
    private val _state = MutableStateFlow(AnimeListState())
    val state = _state.asStateFlow()


}
