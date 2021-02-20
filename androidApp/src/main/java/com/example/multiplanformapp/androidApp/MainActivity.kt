package com.example.multiplanformapp.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multiplanformapp.shared.Greeting
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.icerock.moko.network.generated.models.Recipe
import com.example.multiplanformapp.shared.RecipeModel.RecipeModel
import com.example.multiplanformapp.shared.RecipeModel.IRecipeModel
import com.example.multiplanformapp.shared.RecipeModel.IRecipeUpdater

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity(), IRecipeUpdater {
    val service: IRecipeModel = RecipeModel()
    private var adapter = RecipeAdapter()
    private var list: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById<RecyclerView>(R.id.list)
        list?.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()
        service.recipeAdapter = this
        service.loadRecipes()
    }


    override fun setupItems(items: List<Recipe>) {
        list?.adapter = adapter
        this.adapter.updateItems(items)
    }
}
