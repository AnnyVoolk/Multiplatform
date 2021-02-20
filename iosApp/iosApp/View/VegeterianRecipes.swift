//
//  VegeterianRecipes.swift
//  iosApp
//
//  Created by Anna Volkova on 20.02.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct VegetablesRecipes: View {

    @EnvironmentObject var viewModel: VegetablesRecipesViewModel

    var body: some View {
        List {
            ForEach(viewModel.listDataSource) { recipe in
                VegetablesRecipesCell(title: recipe.titleTrimmed, description: recipe.ingredients ?? "") .onAppear() {
                    if self.viewModel.listDataSource.isLast(recipe) {
                        self.viewModel.upGreatPage()
                       // self.viewModel.fetchPage()
                    }
                }
            }
            if viewModel.isPageLoadings {
                ActivityIndicatorView(style: .medium)
                    .frame(idealWidth: .infinity, maxWidth: .infinity, alignment: .center)
            }
        }
    }
}

struct VegetablesRecipes_Previews: PreviewProvider {
    static var previews: some View {
        VegetablesRecipes()
    }
}

extension Recipe: Identifiable {

    public var id: String {
        title ?? UUID().uuidString
    }

    public var titleTrimmed: String {
        (title ?? "").replacingOccurrences(of: "\n", with: "")
    }
}

extension RandomAccessCollection where Self.Element: Identifiable {

    public func isLast(_ item: Element) -> Bool {
        guard isEmpty == false else {
            return false
        }
        guard let itemIndex = lastIndex(where: { AnyHashable($0.id) == AnyHashable(item.id) }) else {
            return false
        }
        return distance(from: itemIndex, to: endIndex) == 1
    }
}
