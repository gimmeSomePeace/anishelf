package me.gimmesomepeace.anishelf.app.feature.search.list.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import me.gimmesomepeace.anishelf.R
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId
import me.gimmesomepeace.anishelf.app.feature.search.list.model.AnimeListItem

@Composable
fun AnimeCard(
    anime: AnimeListItem,
    onClick: (AnimeId) -> Unit,
) {
    Card(modifier = Modifier.fillMaxWidth().padding(16.dp), onClick = { onClick(anime.id) }) {
        AsyncImage(
            model = anime.thumbnail,
            contentDescription = "Постер аниме ${anime.title}",
            modifier = Modifier
                .aspectRatio(2f / 3f)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.anime_poster_error),
            fallback = painterResource(R.drawable.anime_poster_error),
        )
    }
}
