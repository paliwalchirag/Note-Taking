package com.example.note

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
class Word(@ColumnInfo(name="text")val text: String) {
    @PrimaryKey(autoGenerate = true) var id =0
}