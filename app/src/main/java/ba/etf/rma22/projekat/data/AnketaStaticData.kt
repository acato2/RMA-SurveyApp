package ba.etf.rma22.projekat.data


import ba.etf.rma22.projekat.data.models.Anketa
import java.util.*

fun myAnkete() : List<Anketa>{
    return listOf(
        Anketa(
            "Anketa 1","Istraživanje broj 1", Date(121,11,14), Date(122,11,14),
            Date(122,2,2),1,"Grupa 1", 0.5F
        )

    )
}

fun allAnkete() : List<Anketa>{
    return listOf(
        Anketa( //uradjena
            "Anketa 1","Istraživanje broj 1", Date(121,11,14), Date(122,11,14),
            Date(122,2,2),1,"Grupa 1", 0.33F
        ),
        Anketa( //nije uradjena i nije prosla
            "Anketa 2","Istraživanje broj 2", Date(121,8,11),Date(122,8,11),
            null,1,"Grupa 2", 0F
        ),
        Anketa( //nije uradjena i prosla
            "Anketa 3","Istraživanje broj 3", Date(117,10,10),Date(122,3,3),
            null,5,"Grupa 3", 0F
        ),

        Anketa( //nije uradjena i nije prosla
            "Anketa 4","Istraživanje broj 4", Date(122,11,11),Date(123,11,11),
            null,1,"Grupa 4", 0F
        ),
        Anketa( //nije uradjena i nije prosla
            "Anketa 5","Istraživanje broj 5", Date(121,6,6),Date(123,8,8),
            null,1,"Grupa 5", 0F
        ),
        //dodatni
        Anketa(
            "Anketa 6","Istraživanje broj 2", Date(121,8,11),Date(122,8,11),
            null,1,"Grupa 3", 0F
        ),
        Anketa(
            "Anketa 7","Istraživanje broj 3", Date(117,10,10),Date(122,2,2),
            null,5,"Grupa 5", 0F
        ),
        Anketa(
            "Anketa 8","Istraživanje broj 4", Date(122,11,11),Date(123,11,11),
            null,1,"Grupa 5", 0F
        ),
        Anketa(
            "Anketa 9","Istraživanje broj 5", Date(121,5,5),Date(123,10,10),
            null,1,"Grupa 2", 0F
        ),


        )
}

fun doneAnkete() : List<Anketa>{
    return listOf(
        Anketa(
            "Anketa 1","Istraživanje broj 1", Date(121,11,14), Date(122,11,14),
            Date(122,2,2),1,"Grupa 1", 0.5F
        )


    )
}
fun futureAnkete() : List<Anketa>{
    return listOf(
        Anketa(
            "Anketa 5","Istraživanje broj 5", Date(122,11,11),Date(123,11,11),
            null,1,"Grupa 5", 0F
        ),
        Anketa(
            "Anketa 9","Istraživanje broj 5", Date(121,5,5),Date(123,10,10),
            null,1,"Grupa 2", 0F
        ),


    )
}
fun notTakenAnkete() : List<Anketa>{
    return listOf(
        Anketa(
            "Anketa 3","Istraživanje broj 3", Date(117,10,10),Date(122,3,3),
            null,5,"Grupa 3", 0F
        ),
        Anketa(
            "Anketa 7","Istraživanje broj 3", Date(117,10,10),Date(122,2,2),
            null,5,"Grupa 5", 0F
        ),


    )
}