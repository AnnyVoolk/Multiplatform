package com.example.multiplanformapp.shared

import dev.icerock.moko.network.generated.apis.RecipeApi
import dev.icerock.moko.network.generated.models.RecipeList
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json


class RecipeService {

    val httpClient = HttpClient {}

    private val recipeApi = RecipeApi(
            httpClient = httpClient,
            json = Json {
                ignoreUnknownKeys = true
            }
    )

    suspend fun loadRecipes():RecipeList? {
        return recipeApi.getRecipe(i = "tomato, cucumber, potatoes")
    }
}




