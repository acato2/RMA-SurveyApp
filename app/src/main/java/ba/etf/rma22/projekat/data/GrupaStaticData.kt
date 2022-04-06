package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.models.Grupa

fun allGroups() : List<Grupa>{
    return listOf(
        Grupa("Grupa 2","Istraživanje broj 2"),
        Grupa("Grupa 3","Istraživanje broj 2"),

        Grupa("Grupa 3","Istraživanje broj 3"),
        Grupa("Grupa 5","Istraživanje broj 3"),

        Grupa("Grupa 4","Istraživanje broj 4"),
        Grupa("Grupa 5","Istraživanje broj 4"),

        Grupa("Grupa 2","Istraživanje broj 5"),
        Grupa("Grupa 5","Istraživanje broj 5")
    )
}