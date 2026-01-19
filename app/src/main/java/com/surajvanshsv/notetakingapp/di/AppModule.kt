package com.surajvanshsv.notetakingapp.di

import android.content.Context
import com.surajvanshsv.notetakingapp.room.NoteDao
import com.surajvanshsv.notetakingapp.room.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule  {


    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context) : NoteDatabase {
        return NoteDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase) : NoteDao{
        return noteDatabase.noteDao()
    }
}