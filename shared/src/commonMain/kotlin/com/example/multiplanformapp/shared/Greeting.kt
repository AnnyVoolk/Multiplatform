package com.example.multiplanformapp.shared

import dev.icerock.moko.network.generated.apis.RecipeApi
import dev.icerock.moko.network.generated.models.RecipeList
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
