//
//  VegetablesRecipesCell.swift
//  iosApp
//
//  Created by Anna Volkova on 20.02.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct VegetablesRecipesCell: View {
    @State var title: String
    @State var description: String

    var body: some View {
        VStack(alignment: .leading) {
            Text(title)
                .font(.headline)
                .lineLimit(3)
                .multilineTextAlignment(.leading)
            Text(description)
                .font(.callout)
            Spacer()
        }
        .frame(height: 64)
    }
}

struct VegeterianRecipeCell_Previews: PreviewProvider {
    static var previews: some View {
        VegetablesRecipesCell(title: "", description: "")
    }
}
