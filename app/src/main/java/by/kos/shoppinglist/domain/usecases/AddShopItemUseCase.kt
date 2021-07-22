package by.kos.shoppinglist.domain.usecases

import by.kos.shoppinglist.domain.ShopItem
import by.kos.shoppinglist.domain.repositories.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}