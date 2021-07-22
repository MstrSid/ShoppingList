package by.kos.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import by.kos.shoppinglist.data.ShopListRepositoryImpl //now it is incorrect realisation, because
import by.kos.shoppinglist.domain.ShopItem
// i else don`t know dependency injection. Presentation layer must not know about data layer

import by.kos.shoppinglist.domain.usecases.DeleteShopItemUseCase
import by.kos.shoppinglist.domain.usecases.EditShopItemUseCase
import by.kos.shoppinglist.domain.usecases.GetShopListUseCase

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl //now it is incorrect realisation, because
// i else don`t know dependency injection. Presentation layer must not know about data layer

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }


}