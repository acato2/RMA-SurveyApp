package ba.etf.rma22.projekat.view

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.AnketaTaken
import ba.etf.rma22.projekat.data.models.Odgovor
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.viewmodel.OdgovorViewModel
import ba.etf.rma22.projekat.viewmodel.PitanjeAnketaViewModel
import ba.etf.rma22.projekat.viewmodel.TakeAnketaViewModel


class MyAdapter(private val context: Context, private val arrayList: java.util.ArrayList<String>,pitanjeId:Int) : BaseAdapter() {
    private lateinit var odgovor : TextView
    private var odgovorViewModel = OdgovorViewModel()
    private var pitanjeAnketaViewModel = PitanjeAnketaViewModel()
    private var pitanjeId = pitanjeId
    private lateinit var odg : String
    private var pozicijaOdg :Int = 0

    override fun getCount(): Int {
        return arrayList.size
    }
    override fun getItem(position: Int): Any {
        return position
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.item_odgovor, parent, false)
        odgovor = convertView.findViewById(R.id.idTextViewElementa)
        odgovor.text = arrayList[position]

        convertView.setOnClickListener(View.OnClickListener {
            convertView.isSelected=true
            val selected = (convertView.findViewById(R.id.idTextViewElementa) as TextView).text.toString()
            pozicijaOdg=parent.indexOfChild(it)
            odg=selected
            AnketaRepository.anketaTaken?.id?.let { pitanjeAnketaViewModel.postaviOdgovorAnketa(it,pitanjeId,position) }
        })

        return convertView
    }


    override fun areAllItemsEnabled(): Boolean {
        return true
    }

    override fun isEnabled(arg0: Int): Boolean {
        return true
    }

}