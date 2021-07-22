package by.kos.shoppinglist.domain.usecases

import androidx.lifecycle.LiveData
import by.kos.shoppinglist.domain.ShopItem
import by.kos.shoppinglist.domain.repositories.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}