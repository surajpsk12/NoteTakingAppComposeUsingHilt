package com.surajvanshsv.notetakingapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: Note)

    @Query("select * from notes order by timestamp desc")
     fun getAllNotes() : Flow<List<Note>>

}