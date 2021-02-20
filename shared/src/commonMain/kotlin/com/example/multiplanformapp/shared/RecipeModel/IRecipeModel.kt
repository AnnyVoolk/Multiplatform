package com.example.multiplanformapp.shared.RecipeModel

interface IRecipeModel {
    var recipeAdapter: IRecipeUpdater?
    fun loadRecipes()
}