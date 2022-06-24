package ba.etf.rma22.projekat.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Account(
    @PrimaryKey @SerializedName("id") var id: Long,
    @ColumnInfo (name = "student") @SerializedName("student") var student: String,
    @ColumnInfo (name = "acHash" )@SerializedName("acHash") var acHash: String,
    )
