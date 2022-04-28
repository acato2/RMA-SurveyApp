package ba.etf.rma22.projekat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import ba.etf.rma22.projekat.UtilTestClass.Companion.withTextColor
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MySpirala2AndroidTest {
    @get:Rule
    val intentsTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testZadatak1(){
        //upis na anketu
        onView(withId(R.id.pager)).perform(ViewPager2Actions.scrollToPosition(1))
        onView(withId(R.id.odabirGodina)).perform(click())
        Espresso.onData(CoreMatchers.allOf(CoreMatchers.`is`(CoreMatchers.instanceOf(String::class.java)), CoreMatchers.`is`("1"))).perform(click())
        onView(withId(R.id.odabirIstrazivanja)).perform(click())
        Espresso.onData(CoreMatchers.allOf(CoreMatchers.`is`(CoreMatchers.instanceOf(String::class.java)), CoreMatchers.`is`("Kvalitet nastave na predmetu UUP"))).perform(click())
        onView(withId(R.id.odabirGrupa)).perform(click())
        Espresso.onData(CoreMatchers.allOf(CoreMatchers.`is`(CoreMatchers.instanceOf(String::class.java)), CoreMatchers.`is`("Grupa Programiranje"))).perform(click())

        //provjera FragmentPoruka
        onView(withId(R.id.dodajIstrazivanjeDugme)).perform(ViewActions.click())
        onView(ViewMatchers.withSubstring("Uspješno ste upisani")).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )

        //provjera da li je anketa uspješno dodana u Sve moje ankete
        onView(withId(R.id.pager)).perform(ViewPager2Actions.scrollToPosition(0))
        onView(withId(R.id.filterAnketa)).perform(ViewActions.click())
        Espresso.onData(CoreMatchers.allOf(CoreMatchers.`is`(CoreMatchers.instanceOf(String::class.java)), CoreMatchers.`is`("Sve moje ankete"))).perform(
            ViewActions.click()
        )
        onView(withId(R.id.pager))
            .check(matches(hasDescendant(withText("Kvalitet nastave na predmetu UUP"))));

        //provjera da li je na prvom mjestu u ViewPageru FragmentIstrazivanje
        onView(withId(R.id.pager)).perform(ViewPager2Actions.scrollToPosition(1))
        onView(withId(R.id.odabirGodina)).perform(click())
        Espresso.onData(CoreMatchers.allOf(CoreMatchers.`is`(CoreMatchers.instanceOf(String::class.java)), CoreMatchers.`is`("1"))).perform(click())

    }
    @Test
    fun testZadatak2(){
        //odabir ankete na koju je upisan - Nastavne aktivnosti
        onView(withId(R.id.filterAnketa)).perform(ViewActions.click())
        Espresso.onData(CoreMatchers.allOf(CoreMatchers.`is`(CoreMatchers.instanceOf(String::class.java)), CoreMatchers.`is`("Sve moje ankete"))).perform(
            ViewActions.click()
        )
        val ankete = AnketaRepository.getMyAnkete()
        onView(withId(R.id.listaAnketa)).perform(
            RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(CoreMatchers.allOf(hasDescendant(withText(ankete[0].naziv)),
            hasDescendant(withText(ankete[0].nazivIstrazivanja))), click()))

        //odgovara na prvo pitanje od ukupno 4 pitanja
        onData(anything()).inAdapterView(allOf(withId(R.id.odgovoriLista), isDisplayed())).atPosition(0).perform(
            click())

        //provjera boje teksta
        onData(anything()).inAdapterView(withTextColor(R.color.blue)).atPosition(0)

        //odgovaramo na drugo pitanje
        onView(withId(R.id.pager)).perform(ViewPager2Actions.scrollToPosition(1))
        onData(anything()).inAdapterView(allOf(withId(R.id.odgovoriLista), isDisplayed())).atPosition(0).perform(
            click())

        //provjera boje teksta
        onData(anything()).inAdapterView(withTextColor(R.color.blue)).atPosition(0)

        //odgovaramo na trece pitanje
        onView(withId(R.id.pager)).perform(ViewPager2Actions.scrollToPosition(2))
        onData(anything()).inAdapterView(allOf(withId(R.id.odgovoriLista), isDisplayed())).atPosition(1).perform(
            click())

        //provjera boje teksta
        onData(anything()).inAdapterView(withTextColor(R.color.blue)).atPosition(0)

        //odgovaramo na cetvrto pitanje
        onView(withId(R.id.pager)).perform(ViewPager2Actions.scrollToPosition(3))
        onData(anything()).inAdapterView(allOf(withId(R.id.odgovoriLista), isDisplayed())).atPosition(0).perform(
            click())

        //provjera boje teksta
        onData(anything()).inAdapterView(withTextColor(R.color.blue)).atPosition(0)


        //ide na posljednji fragment - FragmentPredaj
        onView(withId(R.id.pager)).perform(ViewPager2Actions.scrollToLast())

        //provjera da li je progres dobro izracunat
        onView(allOf(withId(R.id.progresTekst), withText("100%"))).check(matches(isDisplayed()))

        //predaja ankete
        onView(withId(R.id.dugmePredaj)).perform(click())

        //provjera fragmenta FragmentPoruka za završenu anketu
        onView(withSubstring("Završili ste anketu")).check(matches(isDisplayed()))

        //provjera da li je anketa prebacena u urađene ankete
        onView(withId(R.id.pager)).perform(ViewPager2Actions.scrollToPosition(0))
        onView(withId(R.id.filterAnketa)).perform(ViewActions.click())
        Espresso.onData(CoreMatchers.allOf(CoreMatchers.`is`(CoreMatchers.instanceOf(String::class.java)), CoreMatchers.`is`("Urađene ankete"))).perform(
            ViewActions.click()
        )
        onView(withId(R.id.pager))
            .check(matches(hasDescendant(withText("Nastavne aktivnosti"))));




    }

}