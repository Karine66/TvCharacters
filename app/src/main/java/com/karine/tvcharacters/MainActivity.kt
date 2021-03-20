package com.karine.tvcharacters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.karine.tvcharacters.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        //for recyclerView
        mainBinding.rvCharacters.adapter = CharactersAdapter()
        mainBinding.rvCharacters.layoutManager = LinearLayoutManager(this)

    }


}