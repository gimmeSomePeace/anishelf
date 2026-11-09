package me.gimmesomepeace.anishelf.app.feature.search.list.model

import me.gimmesomepeace.anishelf.app.domain.anime.model.AnimeId
import me.gimmesomepeace.anishelf.app.domain.common.ImageUri

data class AnimeListItem(
    val id: AnimeId,
    val title: String,
    val thumbnail: ImageUri?,
    val score: Int?,
)
