package me.gimmesomepeace.anishelf.app.domain.common

data class Page<T>(
    val items: List<T>,
    val hasNext: Boolean,
    val currentPage: Int,
) {
    init {
        require(currentPage > 0) { "Номер текущей страницы должен быть положительным числом. Получено: $currentPage" }
    }
}
