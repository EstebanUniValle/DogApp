package com.univalle.dogapp.data
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.univalle.dogapp.model.Inventory

@Dao
interface InventoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveInventory(inventory: Inventory)

    @Query("SELECT * FROM Inventory")
    suspend fun getListInventory(): MutableList<Inventory>

    @Delete
    suspend fun deleteInventory(inventory: Inventory)

    @Update
    suspend fun updateInventory(inventory: Inventory)
}