package com.karine.tvcharacters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CharactersAdapter :RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    val characterList = arrayOf(Characters("Richard Hendricks", "Silicon Valley"),
    Characters("Jared Dunn", "Silicon Valley"),
        Characters("Will McAvoy", "The NewsRoom"),
                Characters("Mackenzie MacHale", "The NewsRoom"),
        Characters("Jim Harper", "The NewsRoom"),
        Characters("Ross Geller", "Friends"),
        Characters("Chandler Bing", "Friends"),
        Characters("Joey Tribianni", "Friends"),
        Characters("Monical Geller", "Friends"),
        Characters("Charlie Harper", "Two and Half men"),
        Characters("Allan Harper", "Two and Half men"),
        Characters("Jake Harper", "Two and Half men"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return characterList.size
    }
    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}