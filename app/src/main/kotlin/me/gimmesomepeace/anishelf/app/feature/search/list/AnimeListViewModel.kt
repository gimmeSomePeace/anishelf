package me.gimmesomepeace.anishelf.app.feature.search.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeRepository
import me.gimmesomepeace.anishelf.app.domain.common.PageRequest
import me.gimmesomepeace.anishelf.app.feature.common.launch
import timber.log.Timber

class AnimeListViewModel(
    private val animeRepository: AnimeRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(AnimeListState())
    val state = _state.asStateFlow()

    private var animeLoadJob: Job? = null
    private var currentPage = FIRST_PAGE_REQUEST

    init {
        loadFirstPage()
    }

    private fun loadFirstPage() {
        animeLoadJob?.cancel()
        val requestedPage = FIRST_PAGE_REQUEST

        _state.update {
            it.copy(isLoading = true, isLoadingMore = false, errorMessage = null)
        }
        animeLoadJob = launch(onError = ::onError) {
            val page = animeRepository.searchAnime(
                request = currentPage,
                filters = _state.value.appliedFilters,
                sorting = _state.value.appliedSorting,
            )
            Timber.i("Loaded anime's page [loadFirstPage]: $page")
            _state.update {
                it.copy(
                    items = page.items.map { anime -> anime.toListItem() },
                    hasMorePages = page.hasNext,
                    isLoading = false,
                    isLoadingMore = false,
                    errorMessage = null,
                )
            }
            currentPage = requestedPage
        }
    }

    private fun loadNextPage() {
        animeLoadJob?.cancel()
        val requestedPage = currentPage.copy(pageNumber = currentPage.pageNumber + 1)

        if (state.value.isLoading || state.value.isLoadingMore) return
        if (!state.value.hasMorePages) return

        _state.update {
            it.copy(isLoading = false, isLoadingMore = true, errorMessage = null)
        }
        animeLoadJob = launch(onError = ::onError) {
            val page = animeRepository.searchAnime(
                request = currentPage,
                filters = _state.value.appliedFilters,
                sorting = _state.value.appliedSorting,
            )
            Timber.i("Loaded anime's page [loadNextPage]: $page")
            _state.update {
                it.copy(
                    items = it.items + page.items.map { anime -> anime.toListItem() },
                    hasMorePages = page.hasNext,
                    isLoading = false,
                    isLoadingMore = false,
                    errorMessage = null,
                )
            }
            currentPage = requestedPage
        }
    }

    private fun onError(e: Throwable) {
        Timber.e(e, "Got error: ${e.message}")
        val errorMessage = "Произошла непредвиденная ошибка"

        _state.update {
            it.copy(
                isLoading = false,
                isLoadingMore = false,
                errorMessage = errorMessage,
            )
        }
    }

    fun onAction(action: AnimeListAction) {
        when (action) {
            is AnimeListAction.FormatRemovedAction -> {
                _state.update {
                    it.copy(
                        appliedFilters = it.appliedFilters.copy(
                            formatIn = it.appliedFilters.formatIn - action.removedFormat,
                        ),
                    )
                }
                loadFirstPage()
            }

            is AnimeListAction.GenreRemovedAction -> {
                _state.update {
                    it.copy(
                        appliedFilters = it.appliedFilters.copy(
                            genreIn = it.appliedFilters.genreIn - action.removedGenre,
                        ),
                    )
                }
                loadFirstPage()
            }

            is AnimeListAction.StatusRemovedAction -> {
                _state.update {
                    it.copy(
                        appliedFilters = it.appliedFilters.copy(
                            statusIn = it.appliedFilters.statusIn - action.removedStatus,
                        ),
                    )
                }
                loadFirstPage()
            }

            is AnimeListAction.QueryChangedAction -> {
                _state.update {
                    it.copy(
                        appliedFilters = it.appliedFilters.copy(
                            query = action.newQuery,
                        ),
                    )
                }
                loadFirstPage()
            }

            is AnimeListAction.SortingChanged -> {
                _state.update {
                    it.copy(appliedSorting = action.newSorting)
                }
                loadFirstPage()
            }

            AnimeListAction.LoadNextPageAction -> loadNextPage()
        }
    }

    companion object {
        private val FIRST_PAGE_REQUEST = PageRequest(
            pageNumber = 1,
            limit = 20,
        )
    }
}
