package com.example.SeventhMonth_1.domain.di

import android.content.Context
import androidx.room.Room
import com.example.SeventhMonth_1.data.lokal.MovieDao
import com.example.SeventhMonth_1.data.lokal.MovieDataBase
import com.example.SeventhMonth_1.data.repositories.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object MovieModule {

    @Singleton
    @Provides
    fun provideContactDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MovieDataBase::class.java,
        "contact_db"

    )

    @Provides
    fun provideMovieDao (movieDataBase: MovieDataBase) = movieDataBase.MovieDao()

    @Provides
    fun provideMovieRepository (movieDao: MovieDao): MovieRepositoryImpl {
        return MovieRepositoryImpl(movieDao)
    }
}
