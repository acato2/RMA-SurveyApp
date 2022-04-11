package ba.etf.rma22.projekat.data


import ba.etf.rma22.projekat.data.models.Anketa
import java.util.*



//tamo gdje upisan prije pokretanja aplikacije
fun myAnkete() : List<Anketa>{
    return listOf(
        Anketa(
            "Nastavne aktivnosti","Kvalitet nastavnih aktivnosti", Date(119,5,5), Date(122,6,6),
            null,20,"Grupa Nastava", 0F
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
            null,20,"Grupa Nastava", 0F
        ),
        Anketa(
            "Programski jezici","Istraživanje o programskim jezicima", Date(122,10,10), Date(124,2,2),
            null,20,"Grupa Nastava", 0F
        ),
        Anketa(
            "Studiranje vani","Istraživanje o studiranju vani", Date(122,7,10), Date(124,2,2),
            null,20,"Grupa Škola", 0F
        ),
        Anketa(
            "Programski jezik Java","Istraživanje o Javi", Date(122,11,10), Date(124,2,22),
            null,20,"Grupa Programiranje", 0F
        ),
        Anketa(
            "Oracle baza podataka","Istraživanje o Oracle bazi podataka", Date(123,9,10), Date(124,9,10),
            null,20,"Grupa Podatak", 0F
        ),
        Anketa(
            "Predmeti u srednjoj školi","Istraživanje o predmetima u srednjoj školi", Date(123,5,5), Date(124,9,10),
            null,20,"Grupa Predmet", 0F
        ),
        Anketa(
            "Grafički dizajn","Istraživanje o grafičkom dizajnu", Date(122,11,11), Date(124,9,9),
            null,20,"Grupa Grafika", 0F
        ),
        Anketa(
            "Mac operativni sistem","Istraživanje o macOS", Date(123,11,11), Date(124,9,9),
            null,20,"Grupa Računar", 0F
        ),
        Anketa(
            "PC Igre","Istraživanje o PC igrama", Date(122,8,11), Date(124,11,11),
            null,20,"Grupa Game", 0F
        ),
        Anketa(
            "Planovi studenata","Istraživanje o budućim planovima", Date(123,10,11), Date(124,11,11),
            null,20,"Grupa Vizija", 0F
        ),
        Anketa(
            "Unapređenje školske nastave","Istraživanje o unapređenju školske nastave", Date(123,1,1), Date(124,1,1),
            null,20,"Grupa Razvoj", 0F
        ),
        Anketa(
            "Uloga knjige u doba pandemije","Istraživanje o ulozi knjige za vrijeme pandemije", Date(124,10,1), Date(126,1,1),
            null,20,"Grupa Five", 0F
        ),

        //nisu uradjene a prosle
        Anketa(
            "Instrukcije","Istraživanje o instrukcijama", Date(121,3,3), Date(122,1,1),
            null,20,"Grupa Nastava", 0.3F
        ),
        Anketa(
            "Pandemija","Istraživanje o uticaju pandemije", Date(121,5,30), Date(122,1,22),
            null,20,"Grupa Nastava", 0F
        ),
        Anketa(
            "Školske uniforme","Istraživanje o uvođenju školskih uniformi", Date(121,5,30), Date(122,1,22),
            null,20,"Grupa Škola", 0F
        ),
        Anketa(
            "Programski jezik C++","Istraživanje o programskom jeziku C++", Date(120,5,10), Date(121,1,2),
            null,20,"Grupa Programiranje", 0F
        ),
        Anketa(
            "Podaci u programima","Istraživanje o čuvanju podataka u programima", Date(120,5,10), Date(120,11,22),
            null,20,"Grupa Podatak", 0F
        ),
        Anketa(
            "Predmeti u osnovnoj školi","Istraživanje o predmetima u osnovnoj školi", Date(119,5,10), Date(122,2,2),
            null,20,"Grupa Predmet", 0F
        ),
        Anketa(
            "Računarska grafika","Istraživanje o računarskoj grafici", Date(120,5,7), Date(121,2,2),
            null,20,"Grupa Grafika", 0F
        ),
        Anketa(
            "Windows operativni sistem","Istraživanje o Windows OS", Date(120,5,7), Date(121,10,10),
            null,20,"Grupa Računar", 0F
        ),
        Anketa(
            "Mobilne igre","Istraživanje o mobilnim igrama", Date(120,7,7), Date(122,2,22),
            null,20,"Grupa Game", 0F
        ),
        Anketa(
            "Unapređenje školovanja","Istraživanje o unapređenju školovanja", Date(120,7,7), Date(121,2,22),
            null,20,"Grupa Vizija", 0F
        ),
        Anketa(
            "Komunikacione vještine","Istraživanje o komunikaciji", Date(120,7,7), Date(121,2,1),
            null,20,"Grupa Razvoj", 0F
        ),
        Anketa(
            "Finansijska pismenost","Istraživanje o finansijskoj pismenosti", Date(120,7,7), Date(120,11,22),
            null,20,"Grupa Five", 0F
        ),

        //nisu uradjene i nisu prosle

        Anketa(
            "Tehnike programiranja I","Kvalitet nastave na predmetu TP", Date(119,5,5), Date(122,6,6),
            null,20,"Grupa Škola", 0F
        ),
        Anketa(
            "Tehnike programiranja II","Kvalitet nastave na predmetu TP", Date(119,5,5), Date(122,10,17),
            null,20,"Grupa Programiranje", 0F
        ),
        Anketa(
            "Uvod u programiranje I","Kvalitet nastave na predmetu UUP", Date(120,9,3), Date(122,6,4),
            null,20,"Grupa Škola", 0F
        ),
        Anketa(
            "Uvod u programiranje II","Kvalitet nastave na predmetu UUP", Date(120,9,3), Date(122,11,29),
            null,20,"Grupa Programiranje", 0F
        ),


        Anketa(
            "Osnove baza podataka I","Kvalitet nastave na predmetu OBP", Date(117,7,7), Date(122,6,3),
            null,20,"Grupa Podatak", 0F
        ),
        Anketa(
            "Osnove baza podataka II","Kvalitet nastave na predmetu OBP", Date(117,7,7), Date(122,5,5),
            null,20,"Grupa Predmet", 0F
        ),
        Anketa(
            "Diskretna matematika I","Kvalitet nastave na predmetu DM", Date(121,3,3), Date(122,6,12),
            null,20,"Grupa Podatak", 0F
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
            null,20,"Grupa Grafika", 0F
        ),
        Anketa(
            "Mobilne komunikacije","Kvalitet nastave na predmetu MK", Date(120,11,2), Date(122,6,9),
            null,20,"Grupa Računar", 0F
        ),

        Anketa(
            "Računarska vizija I","Kvalitet nastave na predmetu RV", Date(118,6,6), Date(122,7,26),
            null,20,"Grupa Game", 0F
        ),
        Anketa(
            "Računarska vizija II","Kvalitet nastave na predmetu RV", Date(118,6,6), Date(123,7,26),
            null,20,"Grupa Vizija", 0F
        ),

        Anketa(
            "Razvoj igara I","Kvalitet nastave na predmetu RI", Date(121,11,5), Date(122,10,25),
            null,20,"Grupa Razvoj", 0F
        ),
        Anketa(
            "Razvoj igara II","Kvalitet nastave na predmetu RI", Date(121,11,5), Date(123,10,25),
            null,20,"Grupa Five", 0F
        ),

        Anketa(
            "Zadovoljstvo studenata I","Zadovoljstvo studenata školovanjem", Date(122,1,11), Date(124,2,2),
            null,20,"Grupa Game", 0F
        ),
        Anketa(
            "Zadovoljstvo studenata II","Zadovoljstvo studenata školovanjem", Date(122,1,11), Date(122,11,12),
            null,20,"Grupa Razvoj", 0F
        ),
        Anketa(
            "Timski rad I","Istraživanje o timskom radu", Date(121,7,5), Date(123,5,25),
            null,20,"Grupa Vizija", 0F
        ),
        Anketa(
            "Timski rad II","Istraživanje o timskom radu", Date(121,5,26), Date(123,5,25),
            null,20,"Five", 0F
        )

        )
}
//uradjene korisnikove iz vec upisane Grupa Nastava
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

}
