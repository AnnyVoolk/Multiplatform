package com.example.multiplanformapp.androidApp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.icerock.moko.network.generated.models.Recipe

class RecipeViewHolder (inflater: LayoutInflater, container: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.recipes,container,false)) {
    private var titleText: TextView? = null
    private  var overviewText: TextView? = null

    init {
        titleText = itemView.findViewById<TextView>(R.id.title_text)
        overviewText = itemView.findViewById<TextView>(R.id.overview_text)
    }

    fun bindItem(item: Recipe) {
        titleText?.text = item.title?.replace(oldValue = "\n", newValue = "")
        overviewText?.text = item.ingredients
    }
}