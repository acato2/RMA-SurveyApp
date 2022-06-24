package ba.etf.rma22.projekat



import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import ba.etf.rma22.projekat.data.models.*
import ba.etf.rma22.projekat.data.repositories.*

import ba.etf.rma22.projekat.view.*
import ba.etf.rma22.projekat.viewmodel.GrupaViewModel
import ba.etf.rma22.projekat.viewmodel.PitanjeAnketaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


class MainActivity : AppCompatActivity(){

    companion object{
        var nez: Int=0
        var nazivIstrazivanja : String = ""
        var brojOdgovorenih : Int =0


    }


    //viewpager
    private lateinit var viewPager2 : ViewPager2
    private lateinit var viewPagerAdapter : ViewPagerAdapter
    private var pitanjeAnketaViewModel = PitanjeAnketaViewModel()
    private var groupViewModel = GrupaViewModel()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewpager
        viewPager2 = findViewById(R.id.pager)


        val fragments: ArrayList<Fragment> = arrayListOf(
            FragmentAnkete(),
            FragmentIstrazivanje()
        )


        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, fragments, lifecycle)
        viewPager2.adapter = viewPagerAdapter


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
                if(viewPagerAdapter.createFragment(0)!=FragmentAnkete() && position==0){
                    viewPagerAdapter.refreshFragment(1,FragmentIstrazivanje())
                }

            }



           override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

            }
        })
        //novo

        AccountRepository.setContext(applicationContext)
        AnketaRepository.setContext(applicationContext)
        OdgovorRepository.setContext(applicationContext)
        PitanjeAnketaRepository.setContext(applicationContext)
        IstrazivanjeIGrupaRepository.setContext(applicationContext)
        TakeAnketaRepository.setContext(applicationContext)


        val payload = intent?.getStringExtra("payload")
        if (payload != null) {
            groupViewModel.changeHash(payload, onSuccess = ::onSuccess5, onError = ::onError)
        }
        else groupViewModel.changeHash("91fd5734-9146-42c3-a963-0394e0110762", onSuccess = ::onSuccess5, onError = ::onError)


    }

    private fun onSuccess5() {
        GlobalScope.launch(Dispatchers.IO){
            withContext(Dispatchers.Main){
                val toast = Toast.makeText(applicationContext, "Sve ok", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    fun onSuccess(uspjesno:Boolean){
        val toast = Toast.makeText(applicationContext, "Spaseno", Toast.LENGTH_SHORT)
        toast.show()
    }
    fun onError() {
        val toast = Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT)
        toast.show()

    }




    fun otvoriPitanja(){
        pitanjeAnketaViewModel.getPitanja(AnketaRepository.pokrenutaAnketa.id,onSuccess=::onSuccessPitanja, onError=::onError)

    }




    fun zavrsenaAnketa() {
        val poruka = "Završili ste anketu ${AnketaRepository.pokrenutaAnketa.naziv} u okviru istraživanja ${AnketaRepository.pokrenutaAnketa.nazivIstrazivanja}"


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
        viewPagerAdapter.refreshFragment(0,FragmentAnkete())


        viewPager2.adapter=viewPagerAdapter
        viewPager2.currentItem=0


    }



    private fun onSuccessPitanja(pitanja: List<Pitanje>) {
        GlobalScope.launch (Dispatchers.IO) {
            withContext(Dispatchers.Main) {
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
            }


    }

    fun proslijediUMain(nazivIstrazivanja: String, nazivGrupe: String) {
        val poruka : String = "Uspješno ste upisani u grupu ${nazivGrupe} istraživanja ${nazivIstrazivanja}!"
        viewPagerAdapter.refreshFragment(1,FragmentPoruka(poruka))
        viewPagerAdapter.refreshFragment(0,FragmentAnkete())

    }


    fun onSuccess2(){
        GlobalScope.launch(Dispatchers.IO){
            withContext(Dispatchers.Main){
                val toast = Toast.makeText(applicationContext, "Sve ok", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}