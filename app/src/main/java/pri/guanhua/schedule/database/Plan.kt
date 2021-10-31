package pri.guanhua.schedule.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plan")
data class Plan(
    @PrimaryKey(autoGenerate = true) val pid: Int,
    @ColumnInfo val memorandum: String?,
    @ColumnInfo val time: String?
)