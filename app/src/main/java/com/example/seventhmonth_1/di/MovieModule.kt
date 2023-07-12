package com.example.seventhmonth_1.di

import android.content.Context
import androidx.room.Room
import com.example.seventhmonth_1.data.lokal.ContactDataBase
import com.example.seventhmonth_1.data.lokal.MovieDao
import com.example.seventhmonth_1.data.repositories.ContactRepositoryImpl
import com.example.seventhmonth_1.domain.repositories.MovieRepository
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
        ContactDataBase::class.java,
        "contact_db"

    )

    @Provides
    fun provideMovieDao (contactDataBase: ContactDataBase) = contactDataBase.MovieDao()

    @Provides
    fun provideMovieRepository (movieDao: MovieDao): MovieRepository{
        return ContactRepositoryImpl(movieDao)
    }
}