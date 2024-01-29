package me.vaimon.doomscroller.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.doomscroller.data.db.AppDatabase
import me.vaimon.doomscroller.data.db.PageKeyDao
import me.vaimon.doomscroller.data.db.PostDao
import me.vaimon.doomscroller.data.sources.ApiDataSource
import me.vaimon.doomscroller.data.sources.paging.PostPagingSource
import me.vaimon.doomscroller.data.sources.paging.PostRemoteMediator
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(ApiDataSource.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideApiDataSource(retrofit: Retrofit.Builder): ApiDataSource {
        return retrofit
            .build()
            .create(ApiDataSource::class.java)
    }

    @Singleton
    @Provides
    fun providePostRemoteMediator(apiDataSource: ApiDataSource, db: AppDatabase, postDao: PostDao, pageKeyDao: PageKeyDao): PostRemoteMediator {
        return PostRemoteMediator(db, postDao, pageKeyDao, apiDataSource)
    }
}