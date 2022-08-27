package com.example.note

import androidx.lifecycle.LiveData

class WordRepository(private val WordDao:WordDao) {

    val allWord: LiveData<List<Word>> = WordDao.getAllWord()

    suspend fun insert(word:Word){
        WordDao.insert(word)
    }

    suspend fun delete(word:Word){
        WordDao.delete(word)
    }

}