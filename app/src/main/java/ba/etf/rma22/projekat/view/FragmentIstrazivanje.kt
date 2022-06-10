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
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.models.Istrazivanje
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeIGrupaRepository
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import ba.etf.rma22.projekat.viewmodel.GrupaViewModel
import ba.etf.rma22.projekat.viewmodel.IstrazivanjeIGrupaViewModel
import ba.etf.rma22.projekat.viewmodel.IstrazivanjeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FragmentIstrazivanje : Fragment(){
    private lateinit var odabirGodina: Spinner
    private lateinit var odabirIstrazivanja : Spinner
    private lateinit var odabirGrupa : Spinner
    private lateinit var arrayAdapter2 : ArrayAdapter<String>
    private lateinit var dodajIstrazivanjeDugme : Button
    private var istrazivanjeIGrupaViewModel = IstrazivanjeIGrupaViewModel()
    private var grupaViewModel = GrupaViewModel()
    private lateinit var view1: View


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 =  inflater.inflate(R.layout.fragment_istrazivanje, container, false)
        odabirGodina = view1.findViewById(R.id.odabirGodina)
        odabirIstrazivanja = view1.findViewById(R.id.odabirIstrazivanja)
        odabirGrupa = view1.findViewById(R.id.odabirGrupa)
        dodajIstrazivanjeDugme = view1.findViewById(R.id.dodajIstrazivanjeDugme)

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
            ArrayAdapter<String>(view1.context, android.R.layout.simple_spinner_item, opcije)
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
                    istrazivanjeIGrupaViewModel.getIstrazivanja(onSuccess = ::onSuccess, onError = ::onError)
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
                        istrazivanjeIGrupaViewModel.getIstrazivanja(
                            onSuccess = ::onSuccess1,
                            onError = ::onError
                        )

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
            istrazivanjeIGrupaViewModel.getGrupe(onSuccess = ::dajIdGrupe,onError = ::onError)
        }
            return view1
    }

    private fun dajIdGrupe (grupe: List<Grupa>) {
        var idGrupe = 0
        for(grupa in grupe){
            if(odabirGrupa.selectedItem.toString().equals(grupa.naziv)){
                idGrupe=grupa.id
            }
        }
        grupaViewModel.upisUGrupu(idGrupe,onSuccess = ::onSuccess2, onError = ::onError)


    }

    fun onSuccess2(upisan: Boolean) {
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                if (upisan) {
                    val nazivIstrazivanja: String = odabirIstrazivanja.selectedItem.toString()
                    val nazivGrupe: String = odabirGrupa.selectedItem.toString()
                    (activity as MainActivity).proslijediUMain(nazivIstrazivanja, nazivGrupe)
                }
            }
        }
    }





    private fun onSuccess1(istrazivanja: List<Istrazivanje>) {
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                var istrazivanjeId = 0
                for(istrazivanje in istrazivanja){
                    if(odabirIstrazivanja.selectedItem.toString().equals(istrazivanje.naziv)){
                        istrazivanjeId = istrazivanje.id
                    }
                }
                istrazivanjeIGrupaViewModel.getGrupeZaIstrazivanje(onSuccess = ::dajGrupe, onError = ::onError,istrazivanjeId)

            }
        }



    }

    private fun dajGrupe(grupe: List<Grupa>) {
        val opcije3 = ArrayList<String>()
        opcije3.add(" ")
        for (grupa in grupe) {
            opcije3.add(grupa.naziv)

        }
        arrayAdapter2 = ArrayAdapter(
            view1.context,
            android.R.layout.simple_spinner_dropdown_item,
            opcije3
        )
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        odabirGrupa.adapter = arrayAdapter2

    }

    fun onSuccess(istrazivanja:List<Istrazivanje>){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val opcije2 = ArrayList<String>()
                opcije2.add(" ")
                for (istrazivanje in istrazivanja) {
                    if(odabirGodina.selectedItem.toString().toInt()==istrazivanje.godina) {
                        opcije2.add(istrazivanje.naziv)
                    }

                }

                arrayAdapter2 = ArrayAdapter(
                    view1.context,
                    android.R.layout.simple_spinner_dropdown_item,
                    opcije2
                )
                arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirIstrazivanja.adapter = arrayAdapter2
            }
        }

    }

    fun onError() {
        val toast = Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
        toast.show()
    }


}