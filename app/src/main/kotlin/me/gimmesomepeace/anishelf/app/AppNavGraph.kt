package me.gimmesomepeace.anishelf.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import me.gimmesomepeace.anishelf.app.config.FeatureFlags
import me.gimmesomepeace.anishelf.app.feature.details.AnimeDetailsRoute
import me.gimmesomepeace.anishelf.app.feature.search.filters.AnimeFiltersRoute
import me.gimmesomepeace.anishelf.app.feature.search.list.AnimeListRoute

object Routes {
    @Serializable
    data object AnimeList

    @Serializable
    data class AnimeDetails(
        val animeId: Int,
    )

    @Serializable
    data object AnimeFilters
}

@Composable
fun AppNavGraph() {
    val controller = rememberNavController()

    NavHost(navController = controller, startDestination = Routes.AnimeList) {
        composable<Routes.AnimeList> {
            AnimeListRoute(
                onAnimeClick = { animeId ->
                    if (FeatureFlags.ANIME_DETAILS_ENABLED) {
                        controller.navigate(Routes.AnimeDetails(animeId.value))
                    }
                },
                onGoToFilters = {
                    if (FeatureFlags.ANIME_FILTERS_ENABLED) {
                        controller.navigate(Routes.AnimeFilters)
                    }
                },
            )
        }

        composable<Routes.AnimeDetails> {
            AnimeDetailsRoute()
        }

        composable<Routes.AnimeFilters> {
            AnimeFiltersRoute()
        }
    }
}
