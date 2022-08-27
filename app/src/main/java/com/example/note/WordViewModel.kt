package com.example.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) :AndroidViewModel(application) {

    private val repository:WordRepository
    val allWord : LiveData<List<Word>>

    init {
        val dao = WordDatabase.getDatabase(application).getWordDao()
        repository = WordRepository(dao)
        allWord = repository.allWord
    }

    fun deleteWord(word:Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(word)
    }

    fun addWord(word:Word)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }

}