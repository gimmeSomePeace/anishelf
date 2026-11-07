package me.gimmesomepeace.anishelf.app.feature.list

import me.gimmesomepeace.anishelf.app.domain.anime.model.Anime
import me.gimmesomepeace.anishelf.app.feature.list.model.AnimeListItem

fun Anime.toListItem() = AnimeListItem(
    id = id,
    title = title,
    thumbnail = poster.thumbnail,
    score = score,
)
