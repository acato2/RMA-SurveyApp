package ba.etf.rma22.projekat.view




import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.PitanjeAnketa
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import java.util.*
import kotlin.collections.ArrayList


class FragmentAnkete : Fragment() {
    private lateinit var ankete : RecyclerView
    private lateinit var anketaListAdapter : AnketaListAdapter
    private var anketeListViewModel= AnketaListViewModel()

    private lateinit var spinner : Spinner



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_ankete, container, false)
        ankete = view.findViewById(R.id.listaAnketa)
        ankete.layoutManager = GridLayoutManager(
            activity,2
        )
        anketaListAdapter = AnketaListAdapter(listOf()) { anketa ->
            otvoriFragmentIProslijediPodatke(anketa.naziv, anketa.nazivIstrazivanja)
        }
        ankete.adapter = anketaListAdapter
        anketaListAdapter.updateAnkete(anketeListViewModel.getAll())





        spinner = view.findViewById(R.id.filterAnketa)
        val opcije = ArrayList<String>()
        opcije.add("Sve moje ankete")
        opcije.add("Sve ankete")
        opcije.add("Urađene ankete")
        opcije.add("Buduće ankete")
        opcije.add("Prošle ankete")

        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(view.context, android.R.layout.simple_spinner_item, opcije)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
        //selekcija
        spinner.setSelection(0);

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val odabranaOpcija = parent.getItemAtPosition(position).toString()
                if (odabranaOpcija.equals("Sve moje ankete")) {
                    val calender = Calendar.getInstance()
                    val year = calender.get(Calendar.YEAR)-1900  // jer koristimo date klasu moramo godinu oduzet od 1900
                    val month = calender.get(Calendar.MONTH)
                    val day = calender.get(Calendar.DAY_OF_MONTH)
                    val currentDate : Date = Date(year,month,day)
                    val mojeAnkete = ArrayList<Anketa>()
                    for(anketa in anketeListViewModel.getMyAnkete()){
                        if(anketa.datumRada!=currentDate ){
                            mojeAnkete.add(anketa)
                        }

                    }
                    anketaListAdapter.updateAnkete(mojeAnkete)
                    anketaListAdapter.notifyDataSetChanged()
                } else if (odabranaOpcija.equals("Sve ankete")) {
                    anketaListAdapter.updateAnkete(anketeListViewModel.getAll())
                    anketaListAdapter.notifyDataSetChanged()
                } else if (odabranaOpcija.equals("Urađene ankete")) {
                    anketaListAdapter.updateAnkete(anketeListViewModel.getDone())
                    anketaListAdapter.notifyDataSetChanged()
                } else if (odabranaOpcija.equals("Buduće ankete")) {
                    anketaListAdapter.updateAnkete(anketeListViewModel.getFuture())
                    anketaListAdapter.notifyDataSetChanged()
                } else if (odabranaOpcija.equals("Prošle ankete")) {
                    anketaListAdapter.updateAnkete(anketeListViewModel.getNotTaken())
                    anketaListAdapter.notifyDataSetChanged()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        return view

    }

    private fun otvoriFragmentIProslijediPodatke(nazivAnkete : String,nazivIstrazivanja : String){
        PitanjeAnketa.anketaNaziv=nazivAnkete
        PitanjeAnketa.istrazivanjeNaziv=nazivIstrazivanja
        if(spinner.selectedItem.equals("Sve moje ankete") || spinner.selectedItem.equals("Urađene ankete")) {
           if(spinner.selectedItem.equals("Urađene ankete")){
                MainActivity.disableDugme=1 }

                (activity as MainActivity).otvoriPitanja()
        }


    }





}