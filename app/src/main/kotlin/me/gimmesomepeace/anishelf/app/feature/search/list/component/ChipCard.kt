package me.gimmesomepeace.anishelf.app.feature.search.list.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ChipCard(
    text: String,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape),
        onClick = onClick,
    ) {
        Text(text = text)
    }
}
