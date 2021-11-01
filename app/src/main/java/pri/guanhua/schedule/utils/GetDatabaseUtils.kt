package pri.guanhua.schedule.utils

import android.content.Context
import androidx.room.Room
import pri.guanhua.schedule.database.AppDatabase

object GetDatabaseUtils {

    private var database: AppDatabase ?= null

    fun get(context: Context): AppDatabase{

        if (database == null){
            database = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "Plan.db"
            ).allowMainThreadQueries().build()
        }

        return database as AppDatabase

    }

}