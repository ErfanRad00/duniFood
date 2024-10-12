package ir.dunijet.dunifood.model

import androidx.room.*

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend  fun insertOrUpdate(food : Food)

//    @Insert
//    fun insertFood(food: Food)

    @Insert
   suspend fun insertAllFoods(data :List<Food>)

//    @Update
//    fun updateFood(food: Food)

    @Delete
     fun deleteFood(food: Food)

    @Query("DELETE FROM table_food")
   suspend fun deleteAllFoods()

    @Query("SELECT * FROM table_food")
   suspend fun getAllFoods(): List<Food>

    @Query("SELECT * FROM table_food WHERE txtSubject LIKE '%' || :searching || '%' ")
   suspend fun searchFoods(searching: String): List<Food>

}