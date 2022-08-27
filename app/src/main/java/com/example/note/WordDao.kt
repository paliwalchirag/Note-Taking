package com.example.note

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note :Word)

    @Delete
    suspend fun delete(note: Word)

    @Query("SELECT * FROM WORD_TABLE ORDER BY id ASC")
    fun getAllWord(): LiveData<List<Word>>
}