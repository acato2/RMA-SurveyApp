package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.models.Istrazivanje

fun allIstrazivanja (): List<Istrazivanje> {
    return listOf(
            Istrazivanje("Istraživanje broj 2",1),
            Istrazivanje("Istraživanje broj 3",1),
            Istrazivanje("Istraživanje broj 4",1),

            Istrazivanje("Istraživanje broj 3",2),
            Istrazivanje("Istraživanje broj 4",2),
            Istrazivanje("Istraživanje broj 5",2),

            Istrazivanje("Istraživanje broj 2",3),
            Istrazivanje("Istraživanje broj 4",3),
            Istrazivanje("Istraživanje broj 5",3),

            Istrazivanje("Istraživanje broj 2",4),
            Istrazivanje("Istraživanje broj 3",4),
            Istrazivanje("Istraživanje broj 4",4),

            Istrazivanje("Istraživanje broj 2",5),
            Istrazivanje("Istraživanje broj 3",5)
        )
}