package com.example.starwarsstarships.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsstarships.R
import com.example.starwarsstarships.domain.model.Starship

class CustomAdapter: RecyclerView.Adapter <CustomAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val textView:TextView
        init {
            textView = itemView.findViewById(R.id.txt_view_starship_name)
        }
    }

    private lateinit var mList: List<Starship>

    fun setData( list: List<Starship>){
        mList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mList[position].name
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}
