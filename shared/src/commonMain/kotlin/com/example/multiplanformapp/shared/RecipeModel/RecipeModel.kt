package com.example.multiplanformapp.shared.RecipeModel

import dev.icerock.moko.network.generated.models.Recipe
import com.example.multiplanformapp.shared.ioDispatcher
import com.example.multiplanformapp.shared.uiDispatcher
import com.example.multiplanformapp.shared.RecipeService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class RecipeModel(): IRecipeModel {
    private var items: ArrayList<Recipe> = arrayListOf()
    private val service: RecipeService = RecipeService()
    val coroutineContext: CoroutineContext = ioDispatcher
    private var scope = PresenterCoroutineScope(coroutineContext)

    override var recipeAdapter: IRecipeUpdater? = null

    override fun loadRecipes() {
        scope.launch {
            val list = service.loadRecipes()
            if (list?.results != null) {
                items.addAll(list.results)
                withContext(uiDispatcher) {
                    recipeAdapter?.setupItems(items)
                }
            }
        }
    }
}

class PresenterCoroutineScope (private val context: CoroutineContext) : CoroutineScope {
    private  var onViewDetachJob = Job()
    override val coroutineContext: CoroutineContext
        get() = context + onViewDetachJob

    fun viewDetached() {
        onViewDetachJob.cancel()
    }
}