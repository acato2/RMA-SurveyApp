package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.models.Istrazivanje


fun allIstrazivanja (): List<Istrazivanje> {
    return listOf(
            Istrazivanje("Kvalitet nastave na predmetu TP",1),
            Istrazivanje("Kvalitet nastave na predmetu UUP",1),
            Istrazivanje("Istraživanje o timskom radu",1),

            Istrazivanje("Kvalitet nastave na predmetu OBP",2),
            Istrazivanje("Kvalitet nastave na predmetu DM",2),
            Istrazivanje("Istraživanje o timskom radu",2),

            Istrazivanje("Kvalitet nastave na predmetu RG",3),
            Istrazivanje("Kvalitet nastave na predmetu MK",3),
            Istrazivanje("Istraživanje o timskom radu",3),

            Istrazivanje("Kvalitet nastave na predmetu RV",4),
            Istrazivanje("Istraživanje o timskom radu",4),
            Istrazivanje("Zadovoljstvo studenata školovanjem",4),

            Istrazivanje("Kvalitet nastave na predmetu RI",5),
            Istrazivanje("Istraživanje o timskom radu",5),
            Istrazivanje("Zadovoljstvo studenata školovanjem",5),
        )
}
fun upisanaIstrazivanja () : List<Istrazivanje>{
        return listOf(
                Istrazivanje("Kvalitet nastavnih aktivnosti",1)
        )
}
