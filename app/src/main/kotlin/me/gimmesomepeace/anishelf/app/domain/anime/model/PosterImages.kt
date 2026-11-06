package me.gimmesomepeace.anishelf.app.domain.anime.model

import me.gimmesomepeace.anishelf.app.domain.common.ImageUri

data class PosterImages(
    val thumbnail: ImageUri? = null,
    val fullSize: ImageUri? = null,
)
