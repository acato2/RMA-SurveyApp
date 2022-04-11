package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.models.Grupa


fun allGroups() : List<Grupa>{
    return listOf(
        Grupa("Grupa Škola","Kvalitet nastave na predmetu TP"),
        Grupa("Grupa Programiranje","Kvalitet nastave na predmetu TP"),

        Grupa("Grupa Škola","Kvalitet nastave na predmetu UUP"),
        Grupa("Grupa Programiranje","Kvalitet nastave na predmetu UUP"),

        Grupa("Grupa Podatak","Kvalitet nastave na predmetu OBP"),
        Grupa("Grupa Predmet","Kvalitet nastave na predmetu OBP"),

        Grupa("Grupa Podatak","Kvalitet nastave na predmetu DM"),
        Grupa("Grupa Predmet","Kvalitet nastave na predmetu DM"),

        Grupa("Grupa Grafika","Kvalitet nastave na predmetu RG"),
        Grupa("Grupa Računar","Kvalitet nastave na predmetu RG"),

        Grupa("Grupa Grafika","Kvalitet nastave na predmetu MK"),
        Grupa("Grupa Računar","Kvalitet nastave na predmetu MK"),

        Grupa("Grupa Game","Kvalitet nastave na predmetu RV"),
        Grupa("Grupa Vizija","Kvalitet nastave na predmetu RV"),

        Grupa("Grupa Razvoj","Kvalitet nastave na predmetu RI"),
        Grupa("Grupa Five","Kvalitet nastave na predmetu RI"),

        Grupa("Grupa Game","Zadovoljstvo studenata školovanjem"),
        Grupa("Grupa Razvoj","Zadovoljstvo studenata školovanjem"),

        Grupa("Grupa Vizija","Istraživanje o timskom radu"),
        Grupa("Grupa Five","Istraživanje o timskom radu"),

        //vec upisan na ovu grupu
        Grupa("Grupa Nastava","Kvalitet online nastave"),
        Grupa("Grupa Nastava","Kvalitet nastave uživo"),
        Grupa("Grupa Nastava","Istraživanje o instrukcijama"),
        Grupa("Grupa Nastava","Istraživanje o uticaju pandemije"),
        Grupa("Grupa Nastava","Istraživanje o razmjeni studenata"),
        Grupa("Grupa Nastava","Istraživanje o programskim jezicima")

        )
}