package pri.guanhua.schedule.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlanDao {

    @Query("SELECT * FROM `plan`")
    fun getAll(): List<Plan>

    @Insert
    fun insertAll(vararg users: Plan)

}