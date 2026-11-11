package me.gimmesomepeace.anishelf.app.feature.search.list.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import me.gimmesomepeace.anishelf.R
import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId
import me.gimmesomepeace.anishelf.app.domain.common.ImageUri
import me.gimmesomepeace.anishelf.app.feature.search.list.model.AnimeListItem
import java.net.URI

@Composable
fun AnimeCard(
    anime: AnimeListItem,
    onClick: (AnimeId) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        onClick = { onClick(anime.id) },
    ) {
        AsyncImage(
            model = anime.thumbnail?.value,
            contentDescription = "Постер аниме ${anime.title}",
            modifier = Modifier
                .aspectRatio(2f / 3f)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.anime_poster_error),
            fallback = painterResource(R.drawable.anime_poster_error),
        )
        Text(
            text = anime.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeCardPreview() {
    AnimeCard(
        anime = AnimeListItem(
            id = AnimeId(1),
            title = "Cowboy Bebop",
            thumbnail = ImageUri(
                URI.create("https://s4.anilist.co/file/anilistcdn/media/anime/cover/medium/bx1-GCsPm7waJ4kS.png"),
            ),
            score = 5,
        ),
        onClick = {},
    )
}
