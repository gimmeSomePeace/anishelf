package me.gimmesomepeace.anishelf.app.domain.anime

import me.gimmesomepeace.anishelf.app.domain.common.VideoUri

@JvmInline
value class YouTubeVideoId(
    val value: String,
)

data class AnimeTrailer(
    val id: YouTubeVideoId?,
    val uri: VideoUri?,
    val embedUri: VideoUri?,
) {
    init {
        require(
            id != null || uri != null || embedUri != null,
        ) { "Трейлер аниме должен иметь хотя бы одно не null поле." }
    }
}
