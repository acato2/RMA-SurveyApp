package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.models.Pitanje

fun svaPitanja(nazivAnkete:String,nazivIstrazivanje: String):List<Pitanje>{
    if(nazivAnkete.equals("Tehnike programiranja I") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu TP")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Tehnike programiranja?",
            listOf("a) Pohađao/la sam Tehnike programiranja","b) Nisam pohađao/la Tehnike programiranja")
        ),
                      Pitanje(
                          "Drugo pitanje",
                          "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                          listOf("a) Kvaliltet nastave na TP je dobar","b) Kvalitet nastave na TP nije dobar")
                      ),
                      Pitanje(
                          "Trece pitanje",
                          "3.Da li ste upisali ocjenu iz Tehnika programiranja?",
                          listOf("a) Upisao/la sam ocjenu iz TP-a","b) Nisam upisao/la ocjenu iz TP-a")
                      )
        )
    }else if(nazivAnkete.equals("Tehnike programiranja II") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu TP")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Tehnike programiranja?",
            listOf("a) Pohađao/la sam Tehnike programiranja","b) Nisam pohađao/la Tehnike programiranja")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na TP je dobar","b) Kvalitet nastave na TP nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Tehnika programiranja?",
                listOf("a) Upisao/la sam ocjenu iz TP-a","b) Nisam upisao/la ocjenu iz TP-a")
            )
        )
    }else if(nazivAnkete.equals("Uvod u programiranje I") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu UUP")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Uvod u programiranje?",
            listOf("a) Pohađao/la sam Uvod u programiranje","b) Nisam pohađao/la Uvod u programiranje")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na UUP je dobar","b) Kvalitet nastave na UUP nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Uvoda u programiranje?",
                listOf("a) Upisao/la sam ocjenu iz UUP-a","b) Nisam upisao/la ocjenu iz UUP-a")
            )
        )
    }else if(nazivAnkete.equals("Uvod u programiranje II") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu UUP")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Uvod u programiranje?",
            listOf("a) Pohađao/la sam Uvod u programiranje","b) Nisam pohađao/la Uvod u programiranje")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na UUP je dobar","b) Kvalitet nastave na UUP nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Uvoda u programiranje?",
                listOf("a) Upisao/la sam ocjenu iz UUP-a","b) Nisam upisao/la ocjenu iz UUP-a")
            )
        )
    }else if(nazivAnkete.equals("Osnove baza podataka I") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu OBP")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Osnove baza podataka?",
            listOf("a) Pohađao/la sam Osnove baza podataka","b) Nisam pohađao/la Osnove baza podataka")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na OBP je dobar","b) Kvalitet nastave na OBP nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Osnova baza podataka?",
                listOf("a) Upisao/la sam ocjenu iz OBP-a","b) Nisam upisao/la ocjenu iz OBP-a")
            )

        )
    }else if(nazivAnkete.equals("Osnove baza podataka II") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu OBP")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Osnove baza podataka?",
            listOf("a) Pohađao/la sam Osnove baza podataka","b) Nisam pohađao/la Osnove baza podataka")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na OBP je dobar","b) Kvalitet nastave na OBP nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Osnova baza podataka?",
                listOf("a) Upisao/la sam ocjenu iz OBP-a","b) Nisam upisao/la ocjenu iz OBP-a")
            )

        )
    }else if(nazivAnkete.equals("Diskretna matematika I") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu DM")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Diskretnu matematiku?",
            listOf("a) Pohađao/la sam Diskretnu matematiku","b) Nisam pohađao/la Diskretnu matematiku")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na DM je dobar","b) Kvalitet nastave na DM nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Diskretne matematike?",
                listOf("a) Upisao/la sam ocjenu iz DM-a","b) Nisam upisao/la ocjenu iz DM-a")
            )
        )
    }else if(nazivAnkete.equals("Diskretna matematika II") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu DM")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Diskretnu matematiku?",
            listOf("a) Pohađao/la sam Diskretnu matematiku","b) Nisam pohađao/la Diskretnu matematiku")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na DM je dobar","b) Kvalitet nastave na DM nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Diskretne matematike?",
                listOf("a) Upisao/la sam ocjenu iz DM-a","b) Nisam upisao/la ocjenu iz DM-a")
            )
        )
    }else if(nazivAnkete.equals("Računarska grafika I") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu RG")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Računarsku grafiku?",
            listOf("a) Pohađao/la sam Računarsku grafiku","b) Nisam pohađao/la Računarski grafiku")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na RG je dobar","b) Kvalitet nastave na RG nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Računarske grafike?",
                listOf("a) Upisao/la sam ocjenu iz RG-a","b) Nisam upisao/la ocjenu iz RG-a")
            )
        )
    }else if(nazivAnkete.equals("Računarska grafika II") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu RG")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Računarsku grafiku?",
            listOf("a) Pohađao/la sam Računarsku grafiku","b) Nisam pohađao/la Računarski grafiku")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na RG je dobar","b) Kvalitet nastave na RG nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Računarske grafike?",
                listOf("a) Upisao/la sam ocjenu iz RG-a","b) Nisam upisao/la ocjenu iz RG-a")
            )
        )
    }else if(nazivAnkete.equals("Mobilne komunikacije I") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu MK")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Mobilne komunikacije?",
            listOf("a) Pohađao/la sam Mobilne komunikacije","b) Nisam pohađao/la Mobilne komunikacije")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na MK je dobar","b) Kvalitet nastave na MK nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Mobilnih komunikacija?",
                listOf("a) Upisao/la sam ocjenu iz MK-a","b) Nisam upisao/la ocjenu iz MK-a")
            )
        )
    } else if(nazivAnkete.equals("Mobilne komunikacije II") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu MK")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Mobilne komunikacije?",
            listOf("a) Pohađao/la sam Mobilne komunikacije","b) Nisam pohađao/la Mobilne komunikacije")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na MK je dobar","b) Kvalitet nastave na MK nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Mobilnih komunikacija?",
                listOf("a) Upisao/la sam ocjenu iz MK-a","b) Nisam upisao/la ocjenu iz MK-a")
            )
        )
    }else if(nazivAnkete.equals("Računarska vizija I") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu RV")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Računarsku viziju?",
            listOf("a) Pohađao/la sam Računarsku viziju","b) Nisam pohađao/la Računarsku viziju")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na RV je dobar","b) Kvalitet nastave na RV nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Računarske vizije?",
                listOf("a) Upisao/la sam ocjenu iz RV-a","b) Nisam upisao/la ocjenu iz RV-a")
            )
        )
    }else if(nazivAnkete.equals("Računarska vizija II") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu RV")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Računarsku viziju?",
            listOf("a) Pohađao/la sam Računarsku viziju","b) Nisam pohađao/la Računarsku viziju")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na RV je dobar","b) Kvalitet nastave na RV nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Računarske vizije?",
                listOf("a) Upisao/la sam ocjenu iz RV-a","b) Nisam upisao/la ocjenu iz RV-a")
            )
        )
    }else if(nazivAnkete.equals("Razvoj igara I") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu RI")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Razvoj igara?",
            listOf("a) Pohađao/la sam Razvoj igara","b) Nisam pohađao/la Razvoj igara")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na RI je dobar","b) Kvalitet nastave na RI nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Razvoja igara?",
                listOf("a) Upisao/la sam ocjenu iz RI-a","b) Nisam upisao/la ocjenu iz RI-a")
            )
        )
    }
    else if(nazivAnkete.equals("Razvoj igara II") && nazivIstrazivanje.equals("Kvalitet nastave na predmetu RI")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste pohađali Razvoj igara?",
            listOf("a) Pohađao/la sam Razvoj igara","b) Nisam pohađao/la Razvoj igara")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li smatrate da je kvalilet nastave na predmetu dobar?",
                listOf("a) Kvaliltet nastave na RI je dobar","b) Kvalitet nastave na RI nije dobar")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste upisali ocjenu iz Razvoja igara?",
                listOf("a) Upisao/la sam ocjenu iz RI-a","b) Nisam upisao/la ocjenu iz RI-a")
            )
        )
    }else if(nazivAnkete.equals("Zadovoljstvo studenata I") && nazivIstrazivanje.equals("Zadovoljstvo studenata školovanjem")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste zadovoljni školovanjem?",
            listOf("a) Zadovoljan sam školovanjem","b) Nisam zadovoljna školovanjem")
        ),
            Pitanje("Drugo pitanje", "2.Da li se online školujete?",
                listOf("a) Školujem se online","b) Ne školujem se online")),
            Pitanje("Trece pitanje", "3.Da li biste nešto promjenili?",
                listOf("a) Promijenio/la bih","b) Ne bih ništa promijenio/la"))
        )
    }else if(nazivAnkete.equals("Zadovoljstvo studenata II") && nazivIstrazivanje.equals("Zadovoljstvo studenata školovanjem")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste zadovoljni školovanjem?",
            listOf("a) Zadovoljan sam školovanjem","b) Nisam zadovoljna školovanjem")
        ),
            Pitanje("Drugo pitanje", "2.Da li se online školujete?",
                listOf("a) Školujem se online","b) Ne školujem se online")),
            Pitanje("Trece pitanje", "3.Da li biste nešto promjenili?",
                listOf("a) Promijenio/la bih","b) Ne bih ništa promijenio/la"))
        )
    }else if(nazivAnkete.equals("Timski rad I") && nazivIstrazivanje.equals("Istraživanje o timskom radu")){
        return listOf(Pitanje("Prvo pitanje", "1.Da li volite timski rad?",
            listOf("a) Volim timski rad","b) Ne volim timski rad")),
            Pitanje("Drugo pitanje", "2.Da li ste ikada radili u timu?",
                listOf("a) Radio/la sam u timu","b) Nisam radio/la u timu"))
        )
    }else if(nazivAnkete.equals("Timski rad II") && nazivIstrazivanje.equals("Istraživanje o timskom radu")){
        return listOf(Pitanje("Prvo pitanje", "1.Da li volite timski rad?",
            listOf("a) Volim timski rad","b) Ne volim timski rad")),
            Pitanje("Drugo pitanje", "2.Da li ste ikada radili u timu?",
                listOf("a) Radio/la sam u timu","b) Nisam radio/la u timu"))

        )
    }
    //


    else if(nazivAnkete.equals("Instrukcije") && nazivIstrazivanje.equals("Istraživanje o instrukcijama")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste ikada uzimali instrukcije?",
            listOf("a) Uzimao/la sam instrukcije","b) Nisam uzimao/la instrukcije")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Smatrate li da su instukcije od pomoći?",
                listOf("a) Smatram da su instrukcije od pomoći","b) Ne smatram da su instrukcije od pomoći")
            )
        )
    }else if(nazivAnkete.equals("Pandemija") && nazivIstrazivanje.equals("Istraživanje o uticaju pandemije")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li je pandemija uticala loše na vaše psihičko zdravlje?",
            listOf("a) Jeste","b) Nije")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li je pandemija uticala loše na kvalitet nastave?",
                listOf("a) Jeste uticala","b) Nije uticala")
            ),
        )
    }else if(nazivAnkete.equals("Školske uniforme") && nazivIstrazivanje.equals("Istraživanje o uvođenju školskih uniformi")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li je smatrate da treba uvesti nošenje uniformi u školama?",
            listOf("a) Treba uvesti nočenje uniformi","b) Ne treba uvesti nošenje uniforme")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li bi vi nosili školsku uniformu?",
                listOf("a) Nosio/la bih uniformu","b) Ne bih nosio/la uniformu")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li poznajete neku školu koja praktikuje nošenje školskih uniformi?",
                listOf("a) Poznajem","b) Ne poznajem")
            )
            )
    }else if(nazivAnkete.equals("Programski jezik C++") && nazivIstrazivanje.equals("Istraživanje o programskom jeziku C++")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste programirali u C++ programskom jeziku?",
            listOf("a) Programirao/la sam u C++","b) Nisam programirao/la u C++")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li više preferirate programirati u nekom drugom programskom jeziku?",
                listOf("a) Više preferirem u C++","b) Više preferiram da nije C++")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li biste C++ preporučili za pravljenje igrica?",
                listOf("a) Preporučio/la bih C++","b) Ne bih preporučio/la C++")
            )
            )
    }else if(nazivAnkete.equals("Podaci u programima") && nazivIstrazivanje.equals("Istraživanje o čuvanju podataka u programima")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li čuvate podatke u bazi podataka?",
            listOf("a) Čuvam","b) Ne čuvam")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li čuvate podatke na neki drugi način?",
                listOf("a) Čuvam u bazi podataka","b) Čuvam na neki drugi način")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li postoji neka alternativa za bazu podataka?",
                listOf("a) Postoji alternativa","b) Ne postoji alternativa")
            )
            )
    }else if(nazivAnkete.equals("Predmeti u osnovnoj školi") && nazivIstrazivanje.equals("Istraživanje o predmetima u osnovnoj školi")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li mislite da postoji neki suvišan predmet u osnovnoj školi?",
            listOf("a) Postoji suvišan predmet","b) Ne postoji suvišan predmet")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li mislite da treba uvesti neki novi predmet u osnovne škole?",
                listOf("a) Treba uvesti novi predmet","b) Ne treba uvesti novi predmet")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li trenutno pohađate osnovnu školu?",
                listOf("a) Pohađam osnovnu školu","b) Ne pohađam osnovnu školu")
            )
            )
    }else if(nazivAnkete.equals("Računarska grafika") && nazivIstrazivanje.equals("Istraživanje o računarskoj grafici")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste upoznati sa nazivom računarska grafika?",
            listOf("a) Upoznat sam sa tim nazivom","b) Nisam upoznat sa tim nazivom")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li ste ikada pohađali istoimeni predmet?",
                listOf("a) Pohađao/la sam istoimeni predmet","b) Nisam pohađao/la istoimeni predmet")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li bi željeli znati više o računarskoj grafici?",
                listOf("a) Volio/voljela bih znati više o grafici","b) Ne bih volio/voljela bih znati više o grafici")
            )
        )
    }else if(nazivAnkete.equals("Windows operativni sistem") && nazivIstrazivanje.equals("Istraživanje o Windows OS")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li smatrate da je Windows dobar operativni sistem?",
            listOf("a) Windows je dobar OS","b) Windows nije dobar OS")
        ),
            Pitanje("Drugo pitanje", "2.Da li vi radite na Windows OS?", listOf("a) Radim na Windows OS","b) Ne radim na Windows OS")),
            Pitanje(
                "Trece pitanje",
                "3.Da li mislite da postoji neki bolji OS od Windowsa?",
                listOf("a) Postoji bolji OS","b) Ne postoji bolji OS")
            )
        )
    }else if(nazivAnkete.equals("Mobilne igre") && nazivIstrazivanje.equals("Istraživanje o mobilnim igrama")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste ljubitelj mobilnih igara?",
            listOf("a) Ljubitelj sam","b) Nisam ljubitelj")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li su mobilne igre, po vama bolje od računarskih?",
                listOf("a) Mobilne igre su bolje","b) Mobilne igre nisu bolje")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste ikada implementirali neku mobilnu igru?",
                listOf("a) Implementirao/la sam","b) Nisam implementirao/la")
            )
        )
    }else if(nazivAnkete.equals("Unapređenje školovanja") && nazivIstrazivanje.equals("Istraživanje o unapređenju školovanja")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li smatrate da je školovanje bez unaprijeđenja dovoljno dobro?",
            listOf("a) Smatram da jeste","b) Smatram da nije")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Ako biste morali, šta biste unaprijedili u školovanju?",
                listOf("a) Unaprijedio/la bih kvalitet nastave","b) Unaprijedio/la bih enterijer")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste zadovoljni dosadašnjim školovanjem?",
                listOf("a) Zadovoljan/na sam dosadašnjim školovanjem","b) Nisam zadovoljan/na dosadašnjim školovanjem")
            )
        )
    }else if(nazivAnkete.equals("Komunikacione vještine") && nazivIstrazivanje.equals("Istraživanje o komunikaciji")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li smatrate da su komunikacione vještine bitne?",
            listOf("a) Smatram da su komunikacione vještine bitne","b) Ne smatram da su komunikacione vještine bitne")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li ste imali nekada problema sa komunikacijom sa strancima?",
                listOf("a) Imao/la sam problema sa strancima","b) Nisam imao/la problema sa strancima")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li biste voljeli unaprijediti vaše komunikacione vještine?",
                listOf("a) Volio/voljela bi unaprijediti","b) Ne bi voljeo/voljela unaprijediti")
            )
        )
    }else if(nazivAnkete.equals("Finansijska pismenost") && nazivIstrazivanje.equals("Istraživanje o finansijskoj pismenosti")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li smatrate da je finansijska pismenost bitna?",
            listOf("a) Smatram da je fnansijska pismenost bitna","b) Ne smatram da je fnansijska pismenost bitna")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li ste imali nekada problema sa finansijskom pismenošću?",
                listOf("a) Imao sam problem","b) Nisam imao problem")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li biste voljeli unaprijediti vašu finansijsku pismenost?",
                listOf("a) Volio/la bi unaprijediti","b) Ne bi voljeo/la unaprijediti")
            )
        )
    }else if(nazivAnkete.equals("Nastavne aktivnosti") && nazivIstrazivanje.equals("Kvalitet nastavnih aktivnosti")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste zadovoljni nastavnim aktivnostima?",
            listOf("a) Zadovoljan sam nastavnim aktivnostima","b) Nisam zadovoljan nastavnim aktivnostima")
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li učestvujete u nekim vannastavnim aktivnostima?",
                listOf("a) Učestvujem","b) Ne učestvujem")
            ),
            Pitanje(
                "Trece pitanje",
                "3.Da li ste zadovoljni radom profesora?",
                listOf("a) Zadovoljan sam radom profesora","b) Nisam zadovoljan radom profesora")
            ),
            Pitanje(
                "Cetvrto pitanje",
                "4.Da li ste zadovoljni radom asistenata?",
                listOf("a) Zadovoljan sam radom asistenata","b) Nisam zadovoljan radom asistenata")
            )
        )
    }

    //uradjene
    else if(nazivAnkete.equals("Online režim") && nazivIstrazivanje.equals("Kvalitet online nastave")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste zadovoljni kvalitetom online nastave?",
            listOf("a) DA","b) NE"),"a) DA"
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li mislite da je online nastava bolja od offline nastave?",
                listOf("a) DA","b) NE"),"b) NE"
            ),
        )
    }
    else if(nazivAnkete.equals("Offline režim") && nazivIstrazivanje.equals("Kvalitet nastave uživo")){
        return listOf(Pitanje(
            "Prvo pitanje",
            "1.Da li ste zadovoljni kvalitetom offline nastave?",
            listOf("a) DA","b) NE"),"a) DA"
        ),
            Pitanje(
                "Drugo pitanje",
                "2.Da li mislite da je offline nastava bolja od online nastave?",
                listOf("a) DA","b) NE"),"a) DA"
            ),
        )
    }

    return listOf()
}