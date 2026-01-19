package com.surajvanshsv.notetakingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surajvanshsv.notetakingapp.repo.NoteRepository
import com.surajvanshsv.notetakingapp.room.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel(){


    val allNotes : Flow<List<Note>> = repository.allNotesInDB

    fun insert(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }


}