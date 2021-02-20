//
//  VegetablesRecipesViewModel.swift
//  iosApp
//
//  Created by Anna Volkova on 20.02.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class VegetablesRecipesViewModel: ObservableObject, IRecipeUpdater {

    private var service: IRecipeModel = RecipeModel()

    @Published private(set) var listDataSource = [Recipe]()

    @Published private(set) var isPageLoadings = false
    @Published private(set) var page = 1

    init() {
        self.service.recipeAdapter = self
        self.service.loadRecipes()
    }

    func setupItems(items: [Recipe]) {
        self.listDataSource = items
    }

    func upGreatPage() {
        self.page += 1
    }

//    func fetchPage() {
//        guard let cashPage = self.cashService?.getCashData(type: cashName) as? Int,
//            cashPage >= self.page, !isPageLoadings else {
//
//                self.isPageLoadings = true
//
//                self.recipesNetWorkService?.getRecipe(type: type, p: page) { list, error in
//                    self.isPageLoadings = false
//                    if let list = list, let results = list.results {
//                        self.cashService?.addCashData(data: self.page, type: cashName)
//                        self.listDataSource.append(contentsOf: results)
//                    }
//                }
//                return
//        }
//    }
}
