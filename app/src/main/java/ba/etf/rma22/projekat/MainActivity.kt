package ba.etf.rma22.projekat


import android.R.attr.button
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.view.AnketaListAdapter
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var ankete : RecyclerView
    private lateinit var anketaListAdapter : AnketaListAdapter
    private var anketeListViewModel= AnketaListViewModel()

    private lateinit var spinner : Spinner
    private lateinit var upisDugme : FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ankete = findViewById(R.id.listaAnketa)
        ankete.layoutManager = GridLayoutManager(
            this,2,GridLayoutManager.VERTICAL,false
        )

        anketaListAdapter= AnketaListAdapter(listOf())
        ankete.adapter=anketaListAdapter
        anketaListAdapter.updateAnkete(anketeListViewModel.getAll())

        spinner=findViewById(R.id.filterAnketa)
        val opcije = ArrayList<String>()
        opcije.add("Sve moje ankete")
        opcije.add("Sve ankete")
        opcije.add("Urađene ankete")
        opcije.add("Buduće ankete")
        opcije.add("Prošle ankete")

        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opcije)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
        spinner.setSelection(1);

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val odabranaOpcija = parent.getItemAtPosition(position).toString()
                if(odabranaOpcija.equals("Sve moje ankete")){
                    anketaListAdapter.updateAnkete(anketeListViewModel.getMyAnkete())
                    anketaListAdapter.notifyDataSetChanged()
                }
                else if(odabranaOpcija.equals("Sve ankete")){
                    anketaListAdapter.updateAnkete(anketeListViewModel.getAll())
                    anketaListAdapter.notifyDataSetChanged()
                }
                else if(odabranaOpcija.equals("Urađene ankete")){

                    anketaListAdapter.updateAnkete(anketeListViewModel.getDone())
                    anketaListAdapter.notifyDataSetChanged()
                }
                else if(odabranaOpcija.equals("Buduće ankete")){
                    anketaListAdapter.updateAnkete(anketeListViewModel.getFuture())
                    anketaListAdapter.notifyDataSetChanged()
                }
                else if(odabranaOpcija.equals("Prošle ankete")){
                    anketaListAdapter.updateAnkete(anketeListViewModel.getNotTaken())
                    anketaListAdapter.notifyDataSetChanged()
            }  }

            override fun onNothingSelected(parent: AdapterView<*>) {

            } }


        upisDugme = findViewById(R.id.upisDugme)
        upisDugme.setOnClickListener {
            val intent = Intent(this,UpisIstrazivanje::class.java)
            startActivity(intent)
        }








    }



}