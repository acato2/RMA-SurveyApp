package ba.etf.rma22.projekat.data.models


import java.util.*

fun myAnkete() : List<Anketa>{
    return listOf(
        Anketa(
            "Online režim","Kvalitet online nastave", Date(115,2,2), Date(122,11,11),
            Date(122,1,1),30,"Grupa Nastava", 1F
        ),
        Anketa(
            "Offline režim","Kvalitet nastave uživo", Date(115,3,3), Date(122,8,8),
            Date(121,7,7),30,"Grupa Nastava", 1F
        ),
        Anketa(
            "Instrukcije","Istraživanje o instrukcijama", Date(121,3,3), Date(122,1,1),
            null,20,"Grupa Škola", 0.3F
        ),
        Anketa(
            "Pandemija","Istraživanje o uticaju pandemije", Date(121,5,30), Date(122,1,22),
            null,20,"Grupa Podatak", 0F
        ),
        Anketa(
            "Razmjena studenata","Istraživanje o razmjeni studenata", Date(122,7,5), Date(124,2,2),
            null,20,"Grupa Fakultet", 0F
        ),
        Anketa(
            "Programski jezici","Istraživanje o programskim jezicima", Date(122,10,10), Date(124,2,2),
            null,20,"Grupa Programiranje", 0F
        )

    )
}
//sve ankete
fun allAnkete() : List<Anketa>{
    return listOf(
        //uradjene
        Anketa(
            "Online režim","Kvalitet online nastave", Date(115,2,2), Date(122,11,11),
            Date(122,1,1),30,"Grupa Nastava", 1F
        ),
        Anketa(
            "Offline režim","Kvalitet nastave uživo", Date(115,3,3), Date(122,8,8),
            Date(121,7,7),30,"Grupa Nastava", 1F
        ),
        //buduce
        Anketa(
            "Razmjena studenata","Istraživanje o razmjeni studenata", Date(122,7,5), Date(124,2,2),
            null,20,"Grupa Fakultet", 0F
        ),
        Anketa(
            "Programski jezici","Istraživanje o programskim jezicima", Date(122,10,10), Date(124,2,2),
            null,20,"Grupa Programiranje", 0F
        ),
        //nisu uradjene a prosle
        Anketa(
            "Instrukcije","Istraživanje o instrukcijama", Date(121,3,3), Date(122,1,1),
            null,20,"Grupa Škola", 0.3F
        ),
        Anketa(
            "Pandemija","Istraživanje o uticaju pandemije", Date(121,5,30), Date(122,1,22),
            null,20,"Grupa Podatak", 0F
        ),
        //nisu uradjene i nisu prosle
        Anketa(
            "Tehnike programiranja I","Kvalitet nastave na predmetu TP", Date(119,5,5), Date(122,6,6),
            null,20,"Grupa Nastava", 0F
        ),
        Anketa(
            "Tehnike programiranja II","Kvalitet nastave na predmetu TP", Date(119,5,5), Date(122,10,17),
            null,20,"Grupa Programiranje", 0F
        ),
        Anketa(
            "Uvod u programiranje I","Kvalitet nastave na predmetu UUP", Date(120,9,3), Date(122,6,4),
            null,20,"Grupa Kreda", 0F
        ),
        Anketa(
            "Uvod u programiranje II","Kvalitet nastave na predmetu UUP", Date(120,9,3), Date(122,11,29),
            null,20,"Grupa Telefon", 0F
        ),
        Anketa(
            "Osnove baza podataka I","Kvalitet nastave na predmetu OBP", Date(117,7,7), Date(122,6,3),
            null,20,"Grupa Baza", 0F
        ),
        Anketa(
            "Osnove baza podataka II","Kvalitet nastave na predmetu OBP", Date(117,7,7), Date(122,5,5),
            null,20,"Grupa Podatak", 0F
        ),
        Anketa(
            "Diskretna matematika I","Kvalitet nastave na predmetu DM", Date(121,3,3), Date(122,6,12),
            null,20,"Grupa Matematika", 0F
        ),
        Anketa(
            "Diskretna matematika II","Kvalitet nastave na predmetu DM", Date(121,3,3), Date(122,10,13),
            null,20,"Grupa Predmet", 0F
        ),
        Anketa(
            "Računarska grafika I","Kvalitet nastave na predmetu RG", Date(120,11,11), Date(122,11,11),
            null,20,"Grupa Grafika", 0F
        ),
        Anketa(
            "Računarska grafika II","Kvalitet nastave na predmetu RG", Date(120,11,11), Date(123,11,11),
            null,20,"Grupa Računar", 0F
        ),
        Anketa(
            "Mobilne komunikacije","Kvalitet nastave na predmetu MK", Date(120,11,2), Date(123,9,9),
            null,20,"Grupa Komunikacija", 0F
        ),
        Anketa(
            "Mobilne komunikacije","Kvalitet nastave na predmetu MK", Date(120,11,2), Date(122,6,9),
            null,20,"Grupa Mobitel", 0F
        ),
        Anketa(
            "Računarska vizija I","Kvalitet nastave na predmetu RV", Date(118,6,6), Date(122,7,26),
            null,20,"Grupa Računar", 0F
        ),
        Anketa(
            "Računarska vizija II","Kvalitet nastave na predmetu RV", Date(118,6,6), Date(123,7,26),
            null,20,"Grupa Vizija", 0F
        ),
        Anketa(
            "Razvoj igara I","Kvalitet nastave na predmetu RI", Date(121,11,5), Date(122,10,25),
            null,20,"Grupa Igre", 0F
        ),
        Anketa(
            "Razvoj igara II","Kvalitet nastave na predmetu RI", Date(121,11,5), Date(123,10,25),
            null,20,"Grupa Programiranje", 0F
        ),
        Anketa(
            "Zadovoljstvo studenata I","Zadovoljstvo studenata školovanjem", Date(122,1,11), Date(124,2,2),
            null,20,"Grupa Fakultet", 0F
        ),
        Anketa(
            "Zadovoljstvo studenata II","Zadovoljstvo studenata školovanjem", Date(122,1,11), Date(122,11,12),
            null,20,"Grupa Škola", 0F
        ),
        Anketa(
            "Timski rad I","Istraživanje o timskom radu", Date(121,7,5), Date(123,5,25),
            null,20,"Grupa Dream Team", 0F
        ),
        Anketa(
            "Timski rad II","Istraživanje o timskom radu", Date(121,5,26), Date(123,5,25),
            null,20,"Grupa Nastava", 0F
        )

        )
}
//uradjene korisnikove
fun doneAnkete() : List<Anketa>{
    return listOf(
        Anketa(
            "Online režim","Kvalitet online nastave", Date(115,2,2), Date(122,11,11),
            Date(122,1,1),30,"Grupa Nastava", 1F
        ),
        Anketa(
            "Offline režim","Kvalitet nastave uživo", Date(115,3,3), Date(122,8,8),
            Date(121,7,7),30,"Grupa Nastava", 0.33F
        )


    )
    //upisan i buduce
}
fun futureAnkete() : List<Anketa>{
    return listOf(
        Anketa(
            "Razmjena studenata","Istraživanje o razmjeni studenata", Date(122,7,5), Date(124,2,2),
            null,20,"Grupa Fakultet", 0F
        ),
        Anketa(
            "Programski jezici","Istraživanje o programskim jezicima", Date(122,10,10), Date(124,2,2),
            null,20,"Grupa Programiranje", 0F
        )
    )
    //korisnikove prosle i nisu uradjene
}
fun notTakenAnkete() : List<Anketa>{
    return listOf(
        Anketa(
            "Instrukcije","Istraživanje o instrukcijama", Date(121,3,3), Date(122,1,1),
            null,20,"Grupa Škola", 0F
        ),
        Anketa(
            "Pandemija","Istraživanje o uticaju pandemije", Date(121,5,30), Date(122,1,22),
            null,20,"Grupa Podatak", 0F
        )

    )
}