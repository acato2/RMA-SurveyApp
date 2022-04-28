package ba.etf.rma22.projekat.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.viewmodel.PitanjeAnketaViewModel


class FragmentPitanje(pitanje : Pitanje) : Fragment() {
    private lateinit var tekstPitanja : TextView
    private lateinit var listaOdgovori : ListView
    private lateinit var dugmeZaustavi : Button
    private lateinit var odgovoriAdapter : MyAdapter
    var odgovori = arrayListOf<String>()
    private var pitanje : Pitanje = pitanje


    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view =  inflater.inflate(R.layout.fragment_pitanje, container, false)
        tekstPitanja=view.findViewById(R.id.tekstPitanja)
        listaOdgovori=view.findViewById(R.id.odgovoriLista)
        dugmeZaustavi = view.findViewById(R.id.dugmeZaustavi)

        odgovoriAdapter=MyAdapter(view.context,odgovori,pitanje.odgovor)

        tekstPitanja.text=pitanje.tekst

        odgovori.addAll(pitanje.opcije)
        odgovoriAdapter=MyAdapter(view.context,odgovori,pitanje.odgovor)
        listaOdgovori.adapter=odgovoriAdapter

        listaOdgovori.choiceMode=ListView.CHOICE_MODE_SINGLE

        dugmeZaustavi.setOnClickListener {
            MainActivity.nez=1
            (activity as MainActivity).zaustaviAnketu()
        }

        return view
    }




}