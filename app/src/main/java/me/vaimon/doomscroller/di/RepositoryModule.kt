package me.vaimon.doomscroller.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.doomscroller.data.repositories.PostRepository
import me.vaimon.doomscroller.data.repositories.impl.PostRepositoryImpl
import me.vaimon.doomscroller.data.sources.ApiDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePostRepository(
        apiDataSource: ApiDataSource
    ) : PostRepository = PostRepositoryImpl(apiDataSource)
}