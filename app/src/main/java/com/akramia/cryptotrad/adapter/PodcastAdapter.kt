package com.akramia.cryptotrad.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.modelsKesfet.Bulten
import com.akramia.cryptotrad.modelsKesfet.Language

class PodcastAdapter(
    private val podcast:List<Language>,
    private val onItemClickListener: (Bulten)->Unit

) :RecyclerView.Adapter<PodcastAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val textView: TextView = itemView.findViewById(R.id.textView1)
        val textView2:TextView=itemView.findViewById(R.id.textView2)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.haberler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return podcast.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val podcast = podcast[position]
        holder.textView.text=podcast.name
        holder.textView2.text=podcast.tarih
        holder.imageView.setImageResource(podcast.image)

    }

}

/*class BultenAdapter(
    private val bulten: List<Bulten>,
    private val onItemClickListener: (Bulten) -> Unit
) : RecyclerView.Adapter<BultenAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bulten_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val bulten = bulten[position]
        holder.textView.text = bulten.bilgi
        holder.textView2.text = bulten.tarih
        holder.itemView.setOnClickListener {
            onItemClickListener(bulten)
        }
    }

    override fun getItemCount(): Int {
        return bulten.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textView2)

    }
}*/