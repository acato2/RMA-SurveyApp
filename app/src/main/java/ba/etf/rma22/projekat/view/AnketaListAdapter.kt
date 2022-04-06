package ba.etf.rma22.projekat.view

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Anketa
import java.text.SimpleDateFormat
import java.util.*

class AnketaListAdapter (private var ankete : List<Anketa>):
    RecyclerView.Adapter<AnketaListAdapter.AnketaViewHolder>() {
    //definisemo elemente svakog elementa liste
    inner class AnketaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nazivAnkete: TextView = view.findViewById(R.id.nazivAnkete)
        val statusAnkete: ImageView = view.findViewById(R.id.statusAnkete)
        val nazivIstrazivanja: TextView = view.findViewById(R.id.nazivIstrazivanja)
        val progresZavrsetka: ProgressBar = view.findViewById(R.id.progresZavrsetka)
        val datumAnkete: TextView = view.findViewById(R.id.datumAnkete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnketaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anketa, parent, false)
        return AnketaViewHolder(view)
    }





    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: AnketaViewHolder, position: Int) {
        holder.nazivAnkete.text = ankete[position].naziv
        //status ankete
        var datumRada = ankete[position].datumRada
        val datumKraja = ankete[position].datumKraj
        val datumPocetka = ankete[position].datumPocetak

        val calender = Calendar.getInstance()

        val year = calender.get(Calendar.YEAR)-1900
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val currentDate : Date = Date(year,month,day)
        val boja : String
        if(datumRada==null && datumKraja.after(currentDate) && datumPocetka.before(currentDate)){ //aktivna ali nije uradjena
            holder.statusAnkete.setImageResource(R.drawable.zelena)
            boja = "zelena"

        }
        else if (datumPocetka.after(currentDate) && datumRada==null && datumKraja.after(currentDate)){ //nije aktivna nije uradjena
            holder.statusAnkete.setImageResource(R.drawable.zuta)
            boja = "zuta"

        }
        else if(datumKraja.before(currentDate) && datumRada==null ){ // anketa prosla i nije uradjena
            holder.statusAnkete.setImageResource(R.drawable.crvena)
            boja = "crvena"


        }
        else{
            holder.statusAnkete.setImageResource(R.drawable.plava)
            boja = "plava"

        }



        //naziv istrazivanja
        holder.nazivIstrazivanja.text = ankete[position].nazivIstrazivanja

        //progres
        var x = ankete[position].progres
        var r = 0.2
        var progres = Math.round(x / r) * r
        progres = progres * 100
        holder.progresZavrsetka.setProgress(progres.toInt(), false)

        //datum


        val sdformat = SimpleDateFormat("dd.MM.YYYY")

        if (boja.equals("plava")) {
            holder.datumAnkete.text = "Anketa urađena: " + sdformat.format(datumRada)
        } else if (boja.equals("zelena")) {
            holder.datumAnkete.text = "Vrijeme zatvaranja: " + sdformat.format(datumKraja)
        } else if (boja.equals("crvena")) {
            holder.datumAnkete.text = "Vrijeme zatvaranja: " + sdformat.format(datumKraja)
        }else {
            holder.datumAnkete.text = "Vrijeme aktiviranja: "+sdformat.format(datumPocetka)}
    }
    override fun getItemCount(): Int = ankete.size

    fun updateAnkete(ankete : List<Anketa>){
        this.ankete=ankete
        notifyDataSetChanged()

    }

}
