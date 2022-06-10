package ba.etf.rma22.projekat.data.models

import com.google.gson.annotations.SerializedName

class PovratniOdg(
    @SerializedName("odgovoreno") var odgovoreno: Int?,
    @SerializedName("AnketaTakenId") var anketaTakenId: Int?,
    @SerializedName("PitanjeId") var pitanjeId: Int?
){

}
