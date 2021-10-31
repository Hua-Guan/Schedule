package pri.guanhua.schedule.database

import androidx.room.Database

@Database(entities = [Plan::class], version = 1)
abstract class AppDatabase {
    abstract fun planDao(): PlanDao
}