package by.kos.shoppinglist.domain.usecases

import by.kos.shoppinglist.domain.ShopItem
import by.kos.shoppinglist.domain.repositories.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): List<ShopItem>{
        return shopListRepository.getShopList()
    }
}