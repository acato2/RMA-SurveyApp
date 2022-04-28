package ba.etf.rma22.projekat.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R


class FragmentPoruka(ispis : String) : Fragment() {

    private lateinit var poruka : TextView
    var ispis = ispis




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_poruka, container, false)
        poruka=view.findViewById(R.id.tvPoruka)
        poruka.text=ispis



        return view
    }





}