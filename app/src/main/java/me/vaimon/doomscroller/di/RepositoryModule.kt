package me.vaimon.doomscroller.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.doomscroller.data.repositories.PostRepository
import me.vaimon.doomscroller.data.repositories.impl.PostRepositoryImpl
import javax.inject.Singleton

//@InstallIn(SingletonComponent::class)
//@Module
//object RepositoryModule {
//
//    @Singleton
//    @Provides
//    fun providePostRepository() : PostRepository = PostRepositoryImpl()
//}