package ba.etf.rma22.projekat

import ba.etf.rma22.projekat.data.models.Anketa
import org.junit.Test
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import junit.framework.Assert.assertEquals
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.hasItem
import org.hamcrest.Matchers.not
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import org.hamcrest.CoreMatchers.`is` as Is



class AnketaRepositoryUnitTest {
    @Test
    fun testGetMyAnkete(){
        val ankete = AnketaRepository.getMyAnkete()
        assertEquals(ankete.size,6)
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Online režim"))))
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Instrukcije"))))
        assertThat(ankete,not(hasItem<Anketa>(hasProperty("naziv",Is("Osnove baza podataka I")))))
    }
    @Test
    fun testGetAll(){
        val ankete = AnketaRepository.getAll()
        assertEquals(ankete.size,26)
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
        assertThat(ankete,hasItem<Anketa>(hasProperty("nazivIstrazivanja", Is("Istraživanje o programskim jezicima"))))
        assertThat(ankete,not(hasItem<Anketa>(hasProperty("naziv",Is("Offline režim")))))
    }
    @Test
    fun testGetNotTaken(){
        val ankete = AnketaRepository.getNotTaken()
        assertEquals(ankete.size,2)
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Pandemija"))))
        assertThat(ankete,hasItem<Anketa>(hasProperty("naziv", Is("Instrukcije"))))
        assertThat(ankete,not(hasItem<Anketa>(hasProperty("naziv",Is("Diskretna matematika I")))))
    }

}