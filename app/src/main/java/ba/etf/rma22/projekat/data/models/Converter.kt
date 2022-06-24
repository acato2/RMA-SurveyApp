package ba.etf.rma22.projekat.data.models

import androidx.room.TypeConverter

class Converter {

    @TypeConverter
    fun fromString(lista: List<String>): String {
        var povratni = ""
        for (i in lista.indices) {
            povratni+=lista[i]
            if (i != lista.size-1)
                povratni+=","
        }
        return povratni
    }

    @TypeConverter
    fun fromList(opcije: String): List<String> {
        return opcije.split(",")
    }
}