package ba.etf.rma22.projekat.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.models.PitanjeAnketa
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.viewmodel.PitanjeAnketaViewModel
import java.lang.String
import java.lang.String.format
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import kotlin.collections.ArrayList


class FragmentPredaj : Fragment() {
    private lateinit var dugmePredaj : Button
    private lateinit var progresTekst : TextView
    private var pitanjaViewModel = PitanjeAnketaViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_predaj, container, false)
        dugmePredaj=view.findViewById(R.id.dugmePredaj)
        progresTekst=view.findViewById(R.id.progresTekst)


        var pitanja = pitanjaViewModel.getPitanja(PitanjeAnketa.anketaNaziv,PitanjeAnketa.istrazivanjeNaziv)
        var brojPitanja = pitanja.size
        var postotak = (MainActivity.brojOdgovorenih.toDouble()/brojPitanja)
        MainActivity.postotak=postotak
        postotak *= 100
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val roundoff=df.format(postotak)
        var string = roundoff.toString()
        progresTekst.text=string+"%"
        //MainActivity.brojOdgovorenih=0

        (activity as MainActivity).vratiNaNulu()

        if(MainActivity.disableDugme==1){
            dugmePredaj.setEnabled(false)
            MainActivity.disableDugme=0
        }

        dugmePredaj.setOnClickListener {
            MainActivity.nez=1
            MainActivity.brojOdgovorenih=0
            (activity as MainActivity).zavrsenaAnketa()
        }

        return view
    }


}