package ba.etf.rma22.projekat.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import ba.etf.rma22.projekat.viewmodel.PitanjeAnketaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


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



        AnketaRepository.anketaTaken?.id?.let { pitanjaViewModel.getProgres(it, onSuccess = ::onSuccess, onError = ::onError) }


        dugmePredaj.setOnClickListener {
            MainActivity.nez=1
            MainActivity.brojOdgovorenih=0
            AnketaRepository.dodajUZavrseneAnkete(AnketaRepository.pokrenutaAnketa)
            (activity as MainActivity).zavrsenaAnketa()

        }

        return view
    }

    private fun onError() {
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val toast = Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    fun onSuccess(rezultat : Int){
        GlobalScope.launch(Dispatchers.IO){
            withContext(Dispatchers.Main){
                progresTekst.text= "${AnketaRepository.anketaTaken!!.progres}%"
            }
        }
    }


}