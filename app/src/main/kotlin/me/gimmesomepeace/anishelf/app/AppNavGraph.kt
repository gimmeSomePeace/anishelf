package me.gimmesomepeace.anishelf.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import me.gimmesomepeace.anishelf.app.feature.details.AnimeDetailsRoute
import me.gimmesomepeace.anishelf.app.feature.list.AnimeListRoute

object Routes {
    @Serializable
    data object AnimeList

    @Serializable
    data class AnimeDetails(
        val id: AnimeId,
    )
}

@Composable
fun AppNavGraph() {
    val controller = rememberNavController()

    NavHost(navController = controller, startDestination = Routes.AnimeList) {
        composable<Routes.AnimeList> {
            AnimeListRoute(
                onAnimeClick = { },
            )
        }

        composable<Routes.AnimeDetails> {
            AnimeDetailsRoute()
        }
    }
}
