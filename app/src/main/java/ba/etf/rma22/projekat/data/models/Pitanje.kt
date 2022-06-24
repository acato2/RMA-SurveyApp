package ba.etf.rma22.projekat.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Pitanje(
    @PrimaryKey @SerializedName("id") var id : Int,
    @ColumnInfo(name = "naziv") @SerializedName("naziv") val naziv : String,
    @ColumnInfo(name = "tekstPitanja") @SerializedName("tekstPitanja") val tekstPitanja : String,
    @ColumnInfo(name = "opcije") val opcije : List<String>
)
