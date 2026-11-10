package me.gimmesomepeace.anishelf.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.gimmesomepeace.anishelf.app.data.anime.repository.FakeAnimeRepository
import me.gimmesomepeace.anishelf.app.domain.anime.repository.AnimeRepository

@Module
@InstallIn(SingletonComponent::class)
object AnimeModule {
    @Provides
    fun provideAnimeRepository(): AnimeRepository = FakeAnimeRepository()
}
