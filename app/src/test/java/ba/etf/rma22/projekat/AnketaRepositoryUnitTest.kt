package ba.etf.rma22.projekat

import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.MojeAnkete
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import junit.framework.Assert.assertEquals
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.hasItem
import org.hamcrest.Matchers.not
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import org.junit.Before
import org.junit.Test
import java.util.*
import org.hamcrest.CoreMatchers.`is` as Is


class AnketaRepositoryUnitTest {

    @Before
    fun prijeMetoda(){
        MojeAnkete.vratiNaPocetno()
    }
    @Test
    fun testGetMyAnkete(){
        val ankete = AnketaRepository.getMyAnkete()
        assertEquals(ankete.size,1)
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Nastavne aktivnosti"))))
        //testiramo upis u novu anketu
        val anketa = Anketa(
            "Timski rad I","Istraživanje o timskom radu", Date(121,7,5), Date(123,5,25),
            null,20,"Grupa Vizija", 0F
        )
        MojeAnkete.dodajUMojeAnkete(anketa)
        assertEquals(ankete.size,2)
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Nastavne aktivnosti"))))
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Timski rad I"))))
        assertThat(ankete,not(hasItem<Anketa>(hasProperty("naziv",Is("Osnove baza podataka I")))))
    }
    @Test
    fun testGetAll(){
        val ankete = AnketaRepository.getAll()
        assertEquals(ankete.size,46)
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Uvod u programiranje I"))))
        assertThat(ankete,hasItem<Anketa>(hasProperty("nazivIstrazivanja", Is("Kvalitet nastave na predmetu DM"))))
        assertThat(ankete,not(hasItem<Anketa>(hasProperty("naziv",Is("Anketa 2")))))
    }
    @Test
    fun testGetDone(){
        val ankete = AnketaRepository.getDone()
        assertEquals(ankete.size,2)
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Offline režim"))))
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Online režim"))))
        assertThat(ankete,not(hasItem<Anketa>(hasProperty("naziv",Is("Pandemija")))))
    }
    @Test
    fun testGetFuture(){
        val ankete = AnketaRepository.getFuture()
        assertEquals(ankete.size,2)
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Razmjena studenata"))))
        //testiramo dodavanje buduce ankete za datu grupu
        val anketa = Anketa(
            "Timski rad I","Istraživanje o timskom radu", Date(121,7,5), Date(123,5,25),
            null,20,"Grupa Vizija", 0F
        )
        MojeAnkete.dodajUMojeAnkete(anketa)
        val noveBuduceAnketeZaGrupu = AnketaRepository.getFuture()
        assertEquals(noveBuduceAnketeZaGrupu.size,3)
        assertThat(noveBuduceAnketeZaGrupu,hasItem<Anketa>(hasProperty("naziv", Is("Planovi studenata"))))
        assertThat(noveBuduceAnketeZaGrupu,not(hasItem<Anketa>(hasProperty("naziv",Is("Offline režim")))))
    }
    @Test
    fun testGetNotTaken(){
        val ankete = AnketaRepository.getNotTaken()
        assertEquals(ankete.size,2)
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Pandemija"))))
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Instrukcije"))))
        val anketa = Anketa(
            "Timski rad I","Istraživanje o timskom radu", Date(121,7,5), Date(123,5,25),
            null,20,"Grupa Vizija", 0F
        )
        MojeAnkete.dodajUMojeAnkete(anketa)
        val noveAnkete = AnketaRepository.getNotTaken()
        assertEquals(noveAnkete.size,3)
        assertThat(noveAnkete,hasItem<Anketa>(hasProperty("naziv", Is("Unapređenje školovanja"))))
    }




}