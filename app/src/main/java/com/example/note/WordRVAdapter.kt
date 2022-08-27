package com.example.note

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordRVAdapter(private val context : Context, private val listener :IWordRVAdapter): RecyclerView.Adapter<WordRVAdapter.WordViewHolder>() {

    private val allWord = ArrayList<Word>()

    inner class WordViewHolder(itenView: View) : RecyclerView.ViewHolder(itenView){
        val textView: TextView = itenView.findViewById(R.id.textView)
        val deleteButton: ImageView = itenView.findViewById(R.id.buttondelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val viewHolder = WordViewHolder(LayoutInflater.from(context).inflate(R.layout.item_word,parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allWord[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {

        val currentWord = allWord[position]
        holder.textView.text = currentWord.text

    }

    override fun getItemCount(): Int {
        return allWord.size
    }

    fun updateList(newWordList:List<Word>){
        allWord.clear()
        allWord.addAll(newWordList)
        notifyDataSetChanged()
    }

}

interface IWordRVAdapter{
    fun onItemClicked(word:Word)
}