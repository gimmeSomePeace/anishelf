package me.gimmesomepeace.anishelf.app.domain.anime.model

import me.gimmesomepeace.anishelf.app.domain.common.ImageUri

data class AnimePoster(
    val small: ImageUri?,
    val large: ImageUri?,
) {
    init {
        require(small != null || large != null) { "Постер аниме должен иметь хотя бы одно не null поле." }
    }
}
