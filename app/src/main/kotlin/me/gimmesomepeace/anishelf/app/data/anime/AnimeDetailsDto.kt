package me.gimmesomepeace.anishelf.app.data.anime

data class AnimeDetailsDto(
    val id: Int? = null,
    val url: String? = null,

    val images: AnimeImagesDto,
    val trailer: AnimeTrailerDto,

    val titles: List<AnimeTitleDto>,
    val status: String? = null,

    val score: Float? = null,
    val rank: Int? = null,
    val rating: String? = null,

    val synopsis: String? = null,
    val genres: List<AnimeListGenreDto>,

    val type: String? = null,

    val episodes: Int? = null,
)
