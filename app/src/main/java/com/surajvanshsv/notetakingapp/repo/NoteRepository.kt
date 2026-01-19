package com.surajvanshsv.notetakingapp.repo

import com.surajvanshsv.notetakingapp.room.Note
import com.surajvanshsv.notetakingapp.room.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun insertNote(note: Note){
        noteDao.insert(note)
    }

    val allNotesInDB : Flow<List<Note>> = noteDao.getAllNotes()

}