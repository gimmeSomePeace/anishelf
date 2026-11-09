package me.gimmesomepeace.anishelf.app.feature.search.list.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun SearchBar(
    query: String,
    onSearchChanged: (String) -> Unit,
) {
    var queryText by rememberSaveable { mutableStateOf(query) }
    LaunchedEffect(query) { queryText = query }

    val currentOnSearchChanged by rememberUpdatedState(onSearchChanged)
    val currentQuery by rememberUpdatedState(query)
    LaunchedEffect(queryText) {
        delay(300.milliseconds)
        if (queryText != currentQuery) currentOnSearchChanged(queryText)
    }

    OutlinedTextField(value = queryText, onValueChange = { queryText = it })
}
