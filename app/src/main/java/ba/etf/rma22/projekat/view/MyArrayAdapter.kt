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
import ba.etf.rma22.projekat.data.models.ListaOdgovora


class MyAdapter(private val context: Context, private val arrayList: java.util.ArrayList<String>,vecUradjene :String) : BaseAdapter() {
    private lateinit var odgovor : TextView
    private var mContext = context
    private var vecUradjene = vecUradjene

    var mcolor = Color.parseColor("#0000FF")


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
            ListaOdgovora.odgovori.add(selected)

            if (mContext is MainActivity) {
                (mContext as MainActivity).brojOdgovorenih()
            }

        })
        for(odg in ListaOdgovora.odgovori) {
            if (odgovor.getText().equals(odg)) {
                odgovor.setTextColor(mcolor)
            }
        }
        if(odgovor.getText().equals(vecUradjene)){
            odgovor.setTextColor(mcolor)
        }


        return convertView
    }
    override fun areAllItemsEnabled(): Boolean {
        return true
    }

    override fun isEnabled(arg0: Int): Boolean {
        return true
    }

}