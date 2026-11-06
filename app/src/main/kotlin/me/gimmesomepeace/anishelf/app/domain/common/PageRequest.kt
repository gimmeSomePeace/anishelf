package me.gimmesomepeace.anishelf.app.domain.common

data class PageRequest(
    val pageNumber: Int,
    val limit: Int,
) {
    init {
        require(pageNumber > 0) { "Номер страницы должен быть положительным числом. Получено: $pageNumber" }
        require(limit > 0) { "Количество элементов на странице должно быть положительным числом. Получено: $limit" }
    }
}
