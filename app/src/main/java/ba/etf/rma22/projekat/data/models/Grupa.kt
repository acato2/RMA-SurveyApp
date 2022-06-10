package ba.etf.rma22.projekat.data.models

import com.google.gson.annotations.SerializedName

data class Grupa(
    @SerializedName("id") var id:Int,
    @SerializedName("naziv") val naziv : String,
    @SerializedName("IstrazivanjeId") var istrazivanjeId : Int,
    val nazivIstrazivanja : String?
)
