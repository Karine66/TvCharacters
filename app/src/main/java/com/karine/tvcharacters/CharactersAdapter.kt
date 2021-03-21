package com.karine.tvcharacters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.karine.tvcharacters.databinding.CellCharactersBinding
import io.realm.Realm
import io.realm.RealmResults

class CharactersAdapter :RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private val characterList: RealmResults<Characters>

    init {
        val realm = Realm.getDefaultInstance()
        characterList = realm.where(Characters::class.java).sort("show").findAll()
        if (characterList.size == 0) {
            val initialCharactersList = arrayOf(
                Characters("Richard Hendricks", "Silicon Valley"),
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
                Characters("Jake Harper", "Two and Half men")
            )
            realm.beginTransaction()
            for(character in initialCharactersList){
                realm.copyToRealm(character)
            }
            realm.commitTransaction()
        }
    }
    fun onCharacterClick(index:Int, context: Context) {
        val character = characterList[index]
        if (character != null) {
            Toast.makeText(context, character.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val cellCharactersBinding = CellCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(cellCharactersBinding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        if (character != null) {
            holder.fillWithCharacter(character)
        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }
    inner class CharacterViewHolder(private val cellCharactersBinding: CellCharactersBinding) : RecyclerView.ViewHolder(cellCharactersBinding.root),
        View.OnClickListener {
        private val ui_title = cellCharactersBinding.uiTitle
        private val ui_subtitle = cellCharactersBinding.uiSubtitle

        init {
            cellCharactersBinding.root.setOnClickListener(this)
        }

        fun fillWithCharacter(characters: Characters) {
            ui_title.text = characters.name
            ui_subtitle.text = characters.show
        }

        override fun onClick(v: View?) {
            if (v != null) {
                onCharacterClick(adapterPosition, v.context)
            }
        }
    }
}