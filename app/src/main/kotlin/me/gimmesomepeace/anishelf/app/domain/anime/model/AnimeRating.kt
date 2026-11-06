package me.gimmesomepeace.anishelf.app.domain.anime.model

/**
 * Целевая аудитория аниме.
 */
enum class AnimeRating {
    /** Все возраста */
    G,

    /** Детский контент */
    PG,

    /** 13+ */
    PG13,

    /** 17+ */
    R_17_PLUS,

    /** Легкая откровенность */
    R_PLUS,

    /** Взрослый контент */
    RX,
}
