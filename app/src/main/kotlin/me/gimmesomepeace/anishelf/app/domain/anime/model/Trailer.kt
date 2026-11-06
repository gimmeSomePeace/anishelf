package me.gimmesomepeace.anishelf.app.domain.anime.model

import me.gimmesomepeace.anishelf.app.domain.common.ImageUri
import me.gimmesomepeace.anishelf.app.domain.common.VideoUri

data class Trailer(
    val videoUri: VideoUri?,
    val thumbnail: ImageUri?
)
