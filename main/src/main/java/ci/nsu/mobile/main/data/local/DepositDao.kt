package ci.nsu.mobile.main.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DepositDao {
    @Query("SELECT * FROM deposits ORDER BY id DESC")
    fun getAll(): Flow<List<DepositEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(calculation: DepositEntity)

    @Query("DELETE FROM deposits")
    fun deleteAll()
}