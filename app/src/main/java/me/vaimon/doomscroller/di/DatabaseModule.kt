package me.vaimon.doomscroller.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.vaimon.doomscroller.data.db.AppDatabase
import me.vaimon.doomscroller.data.db.PageKeyDao
import me.vaimon.doomscroller.data.db.PostDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDb(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providePostDao(db: AppDatabase): PostDao {
        return db.postDao()
    }

    @Singleton
    @Provides
    fun providePageKeyDao(db: AppDatabase): PageKeyDao {
        return db.pageKeyDao()
    }
}