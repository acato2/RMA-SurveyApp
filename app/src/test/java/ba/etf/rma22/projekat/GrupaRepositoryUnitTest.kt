package ba.etf.rma22.projekat

import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import org.junit.Test
import ba.etf.rma22.projekat.data.repositories.GrupaRepository
import junit.framework.Assert.assertEquals
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.hasItem
import org.hamcrest.Matchers.not
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import org.hamcrest.CoreMatchers.`is` as Is


class GrupaRepositoryUnitTest {

    @Test
    fun testGetGroupsByIstrazivanje(){
        val grupe = GrupaRepository.getGroupsByIstrazivanje("Kvalitet nastave na predmetu DM")
        assertEquals(grupe.size,2)
        assertThat(grupe,hasItem<Anketa>(hasProperty("naziv", Is("Grupa Podatak"))))
        assertThat(grupe,hasItem<Anketa>(hasProperty("naziv", Is("Grupa Predmet"))))
        assertThat(grupe,not(hasItem<Anketa>(hasProperty("naziv",Is("Grupa Nastava")))))
    }
}