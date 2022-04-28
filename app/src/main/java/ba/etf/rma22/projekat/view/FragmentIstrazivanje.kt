package ba.etf.rma22.projekat.view


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Istrazivanje
import ba.etf.rma22.projekat.data.models.MojaIstrazivanja
import ba.etf.rma22.projekat.viewmodel.GrupaViewModel
import ba.etf.rma22.projekat.viewmodel.IstrazivanjeViewModel


class FragmentIstrazivanje : Fragment(){
    private lateinit var odabirGodina: Spinner
    private lateinit var odabirIstrazivanja : Spinner
    private lateinit var odabirGrupa : Spinner
    private lateinit var arrayAdapter2 : ArrayAdapter<String>
    private lateinit var dodajIstrazivanjeDugme : Button
    private var istrazivanjeViewModel = IstrazivanjeViewModel()
    private var grupaViewModel = GrupaViewModel()





    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_istrazivanje, container, false)
        odabirGodina = view.findViewById(R.id.odabirGodina)
        odabirIstrazivanja = view.findViewById(R.id.odabirIstrazivanja)
        odabirGrupa = view.findViewById(R.id.odabirGrupa)
        dodajIstrazivanjeDugme = view.findViewById(R.id.dodajIstrazivanjeDugme)

        //prvi spinner

        dodajIstrazivanjeDugme.setEnabled(false)

        val opcije = ArrayList<String>()
        opcije.add(" ")
        opcije.add("1")
        opcije.add("2")
        opcije.add("3")
        opcije.add("4")
        opcije.add("5")


        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(view.context, android.R.layout.simple_spinner_item, opcije)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        odabirGodina.adapter = arrayAdapter
        odabirGodina.setSelection(0)


        //drugi


        odabirGodina.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                val odabranaGodina: String = odabirGodina.getSelectedItem().toString()
                if (odabranaGodina != " ") {
                    val istrazivanja =
                        istrazivanjeViewModel.getIstrazivanjeByGodina(odabranaGodina.toInt())
                    val opcije2 = ArrayList<String>()
                    opcije2.add(" ")
                    for (istrazivanje in istrazivanja) {
                        if(!istrazivanjeViewModel.getUpisani().contains(istrazivanje)){
                            opcije2.add(istrazivanje.naziv)}
                    }
                    arrayAdapter2 = ArrayAdapter(
                        view.context,
                        android.R.layout.simple_spinner_dropdown_item,
                        opcije2
                    )
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    odabirIstrazivanja.adapter = arrayAdapter2
                    dodajIstrazivanjeDugme.setEnabled(true)

                } else {
                    val opcije2 = ArrayList<String>()
                    arrayAdapter2 = ArrayAdapter(
                        view.context,
                        android.R.layout.simple_spinner_dropdown_item,
                        opcije2
                    )
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    odabirIstrazivanja.adapter = arrayAdapter2

                    val opcije3 = ArrayList<String>()
                    arrayAdapter2 = ArrayAdapter(
                        view.context,
                        android.R.layout.simple_spinner_dropdown_item,
                        opcije3
                    )
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    odabirGrupa.adapter = arrayAdapter2
                    dodajIstrazivanjeDugme.setEnabled(false)
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {


            }


        }

        //treci spinner


        odabirIstrazivanja.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val odabranoIstrazivanje: String = odabirIstrazivanja.getSelectedItem().toString()
                if (odabranoIstrazivanje != " ") {
                    val grupe = grupaViewModel.getGroupsByIstrazivanje(odabranoIstrazivanje)
                    val opcije3 = ArrayList<String>()
                    opcije3.add(" ")
                    for (grupa in grupe) {
                        opcije3.add(grupa.naziv)
                    }
                    arrayAdapter2 = ArrayAdapter(
                        view.context,
                        android.R.layout.simple_spinner_dropdown_item,
                        opcije3
                    )
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    odabirGrupa.adapter = arrayAdapter2
                    dodajIstrazivanjeDugme.setEnabled(true)

                } else {
                    val opcije3 = ArrayList<String>()
                    arrayAdapter2 = ArrayAdapter(
                        view.context,
                        android.R.layout.simple_spinner_dropdown_item,
                        opcije3
                    )
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    odabirGrupa.adapter = arrayAdapter2
                    dodajIstrazivanjeDugme.setEnabled(false)
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }



        }
        odabirGrupa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val odabranaGrupa: String = odabirGrupa.getSelectedItem().toString()
                if (odabranaGrupa != " ") {
                    dodajIstrazivanjeDugme.setEnabled(true)

                } else {
                    dodajIstrazivanjeDugme.setEnabled(false)
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }


        }
        dodajIstrazivanjeDugme.setOnClickListener{
            val nazivIstrazivanja : String = odabirIstrazivanja.getSelectedItem().toString()
            val nazivGrupe : String = odabirGrupa.getSelectedItem().toString()
            val godinaIstrazivanja : String = odabirGodina.getSelectedItem().toString()
            MojaIstrazivanja.dodajUMojaIstrazivanja(Istrazivanje(nazivIstrazivanja,godinaIstrazivanja.toInt()))
            MainActivity.brojOdgovorenih=0
            (activity as MainActivity).proslijediUMain(nazivIstrazivanja,nazivGrupe)
        }
            return view
    }





}