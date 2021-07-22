package by.kos.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.kos.shoppinglist.domain.ShopItem
import by.kos.shoppinglist.domain.repositories.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0
    private val shopListLiveData = MutableLiveData<List<ShopItem>>()

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId
            autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()

    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shoItem: ShopItem) {
        val old = getShopItem(shoItem.id)
        shopList.remove(old)
        addShopItem(shoItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLiveData
    }

    private fun updateList() {
        shopListLiveData.value = shopList.toList()
    }
}