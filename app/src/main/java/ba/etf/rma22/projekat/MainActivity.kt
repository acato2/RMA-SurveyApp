package ba.etf.rma22.projekat



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import ba.etf.rma22.projekat.data.models.*
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.view.*
import ba.etf.rma22.projekat.viewmodel.PitanjeAnketaViewModel
import java.util.*


class MainActivity : AppCompatActivity(){

    companion object{
        var nez: Int=0
        var nazivIstrazivanja : String = ""
        var nazivGrupe : String = ""
        var brojOdgovorenih : Int =0
        var postotak : Double=0.0
        var disableDugme : Int=0


    }


    //viewpager
    private lateinit var viewPager2 : ViewPager2
    private lateinit var viewPagerAdapter : ViewPagerAdapter
    private var pitanjeAnketaViewModel = PitanjeAnketaViewModel()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewpager
        viewPager2 = findViewById(R.id.pager)


        val fragments: ArrayList<Fragment> = arrayListOf(
            FragmentAnkete(),
            FragmentIstrazivanje()
        )


        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,fragments,lifecycle)
        viewPager2.adapter=viewPagerAdapter


        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
           /* override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }*/

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val pitanja = pitanjeAnketaViewModel.getPitanja(
                    PitanjeAnketa.anketaNaziv,
                    PitanjeAnketa.istrazivanjeNaziv
                )
                if (pitanja.size != 0) {

                    if (position==viewPagerAdapter.itemCount-1 && nez!=1) {
                        nez=0
                        viewPagerAdapter.refreshFragment(
                            viewPagerAdapter.itemCount - 1,
                            FragmentPredaj()
                        )
                    }
                }
                if(viewPagerAdapter.createFragment(0)!=FragmentAnkete() && position==0){
                    viewPagerAdapter.refreshFragment(1,FragmentIstrazivanje())
                }

            }

            /*

           override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

            }*/
        })


    }
    fun proslijediUMain(istrazivanje: String, grupa: String) {
        nazivIstrazivanja=istrazivanje
        nazivGrupe=grupa
        val istrazivanje: String = istrazivanje
        val grupa: String = grupa
        val sveAnkete = AnketaRepository.getAll()
        for (anketa in sveAnkete) {
            if (anketa.nazivIstrazivanja.equals(istrazivanje) && anketa.nazivGrupe.equals(grupa)) {
                if (!MojeAnkete.mojeAnkete.contains(anketa))MojeAnkete.dodajUMojeAnkete(anketa)

            }
        }
        val poruka : String = "Uspješno ste upisani u grupu ${nazivGrupe} istraživanja ${nazivIstrazivanja}!"
        viewPagerAdapter.refreshFragment(1,FragmentPoruka(poruka))
        viewPagerAdapter.refreshFragment(0,FragmentAnkete())


    }

    fun otvoriPitanja(){
        val pitanja = pitanjeAnketaViewModel.getPitanja(PitanjeAnketa.anketaNaziv,PitanjeAnketa.istrazivanjeNaziv)
        if(pitanja.size==1){
            viewPagerAdapter.refreshFragment(0,FragmentPitanje(pitanja[0]))
            viewPagerAdapter.refreshFragment(1,FragmentPredaj())
        }
        else if (pitanja.size==2){
            viewPagerAdapter.refreshFragment(0,FragmentPitanje(pitanja[0]))
            viewPagerAdapter.refreshFragment(1,FragmentPitanje(pitanja[1]))
            viewPagerAdapter.add(2,FragmentPredaj())
        } else{
            var i = 2
            var br = 2
            viewPagerAdapter.refreshFragment(0, FragmentPitanje(pitanja[0]))
            viewPagerAdapter.refreshFragment(1, FragmentPitanje(pitanja[1]))
            while(i<pitanja.size) {
                viewPagerAdapter.add(br,FragmentPitanje(pitanja[i]))
                br++
                i++
            }
            viewPagerAdapter.add(i,FragmentPredaj())
        }





    }

    fun brojOdgovorenih() {
        brojOdgovorenih++
    }


    fun zavrsenaAnketa() {
        var istrazivanje = PitanjeAnketa.istrazivanjeNaziv
        var naziv = PitanjeAnketa.anketaNaziv
        val sveAnkete = AnketaRepository.getAll()
        for (anketa in sveAnkete) {
            if ((anketa.nazivIstrazivanja.equals(istrazivanje) && anketa.naziv.equals(naziv))) {
                if(!UradjeneAnkete.uradjeneAnkete.contains(anketa)) {
                    if(anketa.naziv.equals("Nastavne aktivnosti")){
                        MojeAnkete.odradjenaUpisana==1
                    }
                    else{
                        MojeAnkete.odradjenaUpisana==0
                    }
                    UradjeneAnkete.obrisiStaruAnketu(anketa)
                    val calender = Calendar.getInstance()
                    val year = calender.get(Calendar.YEAR)-1900  // jer koristimo date klasu moramo godinu oduzet od 1900
                    val month = calender.get(Calendar.MONTH)
                    val day = calender.get(Calendar.DAY_OF_MONTH)
                    val currentDate : Date = Date(year,month,day)
                    anketa.datumRada=currentDate
                    anketa.progres= postotak.toFloat()
                    UradjeneAnkete.dodajUUradjeneAnkete(anketa)
                    UradjeneAnkete.dodajNovuAnketu(anketa)

                }

            }
        }
        val poruka = "Završili ste anketu ${PitanjeAnketa.anketaNaziv} u okviru istraživanja ${PitanjeAnketa.istrazivanjeNaziv}"


        viewPager2=findViewById(R.id.pager)
        viewPagerAdapter.refreshFragment(0,FragmentAnkete())
        viewPagerAdapter.refreshFragment(1,FragmentPoruka(poruka))
        var pages = viewPagerAdapter.itemCount
        var i =2
        while(i<pages){
            viewPagerAdapter.remove(i)
            pages--
        }
        viewPager2.adapter=viewPagerAdapter
        viewPager2.currentItem=1

    }

    fun zaustaviAnketu() {
        viewPager2=findViewById(R.id.pager)
        viewPagerAdapter.refreshFragment(0,FragmentAnkete())
        viewPagerAdapter.refreshFragment(1,FragmentIstrazivanje())
        var pages = viewPagerAdapter.itemCount
        var i =2
        while(i<pages){
            viewPagerAdapter.remove(i)
            pages--
        }
        var istrazivanje = PitanjeAnketa.istrazivanjeNaziv
        var naziv = PitanjeAnketa.anketaNaziv
        val sveAnkete = AnketaRepository.getMyAnkete()
        for (anketa in sveAnkete) {
            if ((anketa.nazivIstrazivanja.equals(istrazivanje) && anketa.naziv.equals(naziv))) {
                MojeAnkete.obrisiStaruAnketu(anketa)
                var pitanja = pitanjeAnketaViewModel.getPitanja(PitanjeAnketa.anketaNaziv,PitanjeAnketa.istrazivanjeNaziv)
                var brojPitanja = pitanja.size
                var postotak = (brojOdgovorenih.toDouble()/brojPitanja)
                anketa.progres= postotak.toFloat()
                MojeAnkete.dodajNovuAnketu(anketa)

            }

        }
        viewPagerAdapter.refreshFragment(0,FragmentAnkete())


        viewPager2.adapter=viewPagerAdapter
        viewPager2.currentItem=0


    }

    fun vratiNaNulu() {
        if(viewPager2.currentItem.equals(FragmentPredaj())){
            brojOdgovorenih=0
        }
    }




}