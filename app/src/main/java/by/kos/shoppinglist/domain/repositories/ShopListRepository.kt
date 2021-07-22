package by.kos.shoppinglist.domain.repositories

import by.kos.shoppinglist.domain.ShopItem

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shoItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    fun getShopList(): List<ShopItem>
}