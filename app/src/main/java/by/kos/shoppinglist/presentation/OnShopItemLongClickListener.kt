package by.kos.shoppinglist.presentation

import by.kos.shoppinglist.domain.ShopItem

interface OnShopItemLongClickListener {
    fun onShopItemLongClick(shopItem: ShopItem):Boolean
}