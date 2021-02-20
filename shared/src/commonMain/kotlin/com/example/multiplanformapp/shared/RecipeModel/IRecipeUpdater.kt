package com.example.multiplanformapp.shared.RecipeModel
import dev.icerock.moko.network.generated.models.Recipe

interface IRecipeUpdater {
    fun setupItems(items: List<Recipe>)
}