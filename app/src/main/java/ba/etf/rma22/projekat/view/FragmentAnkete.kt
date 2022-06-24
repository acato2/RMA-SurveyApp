package ba.etf.rma22.projekat.view




import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import ba.etf.rma22.projekat.viewmodel.GrupaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
            anketa.nazivIstrazivanja?.let {prikaziAnketu(anketa) }
        }



        ankete.adapter = anketaListAdapter


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
        spinner.setSelection(1);

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val odabranaOpcija = parent.getItemAtPosition(position).toString()
                if (odabranaOpcija.equals("Sve moje ankete")) {
                    anketeListViewModel.getMyAnkete(
                        onSuccess = ::onSuccess,
                        onError = ::onError
                    )
                } else if (odabranaOpcija.equals("Sve ankete")) {
                    anketeListViewModel.getAll(
                        onSuccess = ::onSuccess,
                        onError = ::onError
                    )
                } else if (odabranaOpcija.equals("Urađene ankete")) {
                    anketeListViewModel.getDone(
                        onSuccess = ::onSuccess,
                        onError = ::onError
                    )
                } else if (odabranaOpcija.equals("Buduće ankete")) {
                    anketeListViewModel.getFuture(
                        onSuccess = ::onSuccess,
                        onError = ::onError
                    )
                } else if (odabranaOpcija.equals("Prošle ankete")) {
                   anketeListViewModel.getNotTaken(
                        onSuccess = ::onSuccess,
                        onError = ::onError
                    )
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


        return view

    }

    private fun prikaziAnketu(anketa : Anketa) {
        if(!spinner.selectedItem.toString().equals("Sve ankete")){
            AnketaRepository.pokrenutaAnketa=anketa
            anketeListViewModel.getPoceteAnketeApp2(anketa,onSuccess = ::onSuccessPocni, onError = ::onError)
        }

    }

    private fun onSuccessPocni(rezultat: Boolean, anketa: Anketa) {
        GlobalScope.launch (Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val toast = Toast.makeText(context, "Anketa zapoceta", Toast.LENGTH_SHORT)
                toast.show()
                (activity as MainActivity).otvoriPitanja()
            }
        }
    }

    fun onSuccess(ankete:List<Anketa>){
        anketaListAdapter.updateAnkete(ankete)
    }
    fun onError() {
        val toast = Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
        toast.show()
    }





}