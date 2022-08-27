package com.example.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IWordRVAdapter {

    lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recview.layoutManager = LinearLayoutManager(this)
        val adapter = WordRVAdapter(this,this)
        recview.adapter= adapter

        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(WordViewModel::class.java)

        viewModel.allWord.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }
        })

    }

    override fun onItemClicked(word: Word) {
        viewModel.deleteWord((word))
        Toast.makeText(this,"${word.text} Deleted",Toast.LENGTH_SHORT).show()
    }

    fun submitdata(view: View) {
        val wordText = editTextTextPersonName.text.toString()
        if(wordText.isNotEmpty()){
            viewModel.addWord(Word(wordText))
        }
    }
}