package by.kos.shoppinglist.domain.usecases

import by.kos.shoppinglist.domain.ShopItem
import by.kos.shoppinglist.domain.repositories.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}