package c14220131.paba.tugastodolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterRecView (private val listTask:ArrayList<tasklist>) : RecyclerView.Adapter<adapterRecView.ListViewHolder>(){


    inner class ListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var _deskripsi = itemView.findViewById<TextView>(R.id.deskripsi)
        var _judul = itemView.findViewById<TextView>(R.id.namaTask)
        var _tanggal = itemView.findViewById<TextView>(R.id.tanggal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycle,parent,false)
        return  ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var task = listTask[position]

        holder._judul.setText(task.judul)
        holder._tanggal.setText(task.tanggal)
        holder._deskripsi.setText(task.deskripsi)
    }
}
