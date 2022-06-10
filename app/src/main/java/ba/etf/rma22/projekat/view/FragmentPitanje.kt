package ba.etf.rma22.projekat.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.viewmodel.PitanjeAnketaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FragmentPitanje(pitanje : Pitanje) : Fragment() {
    private lateinit var tekstPitanja : TextView
    private lateinit var listaOdgovori : ListView
    private lateinit var dugmeZaustavi : Button
    private lateinit var odgovoriAdapter : MyAdapter
    private lateinit var adapter: ArrayAdapter<String>
    var odgovori = arrayListOf<String>()
    private var pitanje : Pitanje = pitanje
    private var pitanjeAnketaViewModel = PitanjeAnketaViewModel()


    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view =  inflater.inflate(R.layout.fragment_pitanje, container, false)
        tekstPitanja=view.findViewById(R.id.tekstPitanja)
        listaOdgovori=view.findViewById(R.id.odgovoriLista)
        dugmeZaustavi = view.findViewById(R.id.dugmeZaustavi)



        tekstPitanja.text=pitanje.tekstPitanja

        odgovori.addAll(pitanje.opcije)
        odgovoriAdapter=MyAdapter(view.context,odgovori,pitanje.id)
        listaOdgovori.adapter= odgovoriAdapter


        listaOdgovori.choiceMode=ListView.CHOICE_MODE_SINGLE



       dugmeZaustavi.setOnClickListener {
            MainActivity.nez=1
            (activity as MainActivity).zaustaviAnketu()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
        while(AnketaRepository.anketaTaken == null);
        AnketaRepository.anketaTaken?.id?.let {
            pitanjeAnketaViewModel.getOdgovor(it,pitanje.id,onSuccess=::onSuccess,onError=::onError)
        }
        }, 1)


    }

    private fun onError() {
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val toast = Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    fun onSuccess(odgovor: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                if (listaOdgovori.getChildAt(0) != null) {
                    if (odgovor != -1) {
                      //greska
                      var izabran = listaOdgovori?.getChildAt(odgovor).findViewById<TextView>(R.id.idTextViewElementa)
                        izabran.setTextColor(Color.parseColor("#0000FF"))
                    }


                    }

            }

        }
    }


}