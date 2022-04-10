package ba.etf.rma22.projekat

import ba.etf.rma22.projekat.data.models.Anketa
import org.junit.Test
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeRepository
import junit.framework.Assert.assertEquals
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.hasItem
import org.hamcrest.Matchers.not
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import org.hamcrest.CoreMatchers.`is` as Is

class IstrazivanjeRepositoryUnitTest {
    @Test
    fun testGetIstrazivanjeByGodina(){
        val istrazivanja = IstrazivanjeRepository.getIstrazivanjeByGodina(2)
        assertEquals(istrazivanja.size,3)
        assertThat(istrazivanja,hasItem<Anketa>(hasProperty("naziv", Is("Istraživanje o timskom radu"))))
        assertThat(istrazivanja,hasItem<Anketa>(hasProperty("naziv", Is("Kvalitet nastave na predmetu OBP"))))
        assertThat(istrazivanja,not(hasItem<Anketa>(hasProperty("naziv",Is("Kvalitet nastave na predmetu RG")))))
    }
    @Test
    fun testGetAll(){
        val istrazivanja = IstrazivanjeRepository.getAll()
        assertEquals(istrazivanja.size,15)
        assertThat(istrazivanja,hasItem<Anketa>(hasProperty("naziv", Is("Kvalitet nastave na predmetu MK"))))
        assertThat(istrazivanja,hasItem<Anketa>(hasProperty("naziv", Is("Istraživanje o timskom radu"))))
        assertThat(istrazivanja,not(hasItem<Anketa>(hasProperty("naziv",Is("Kvalitet nastave na predmetu RL")))))
    }
    @Test
    fun testGetUpisani(){
        val istrazivanja = IstrazivanjeRepository.getUpisani()
        assertEquals(istrazivanja.size,2)
        assertThat(istrazivanja,hasItem<Anketa>(hasProperty("naziv", Is("Kvalitet online nastave"))))
        assertThat(istrazivanja,hasItem<Anketa>(hasProperty("naziv", Is("Kvalitet offline nastave"))))
        assertThat(istrazivanja,not(hasItem<Anketa>(hasProperty("naziv",Is("Kvalitet nastave na predmetu DM")))))
    }
}