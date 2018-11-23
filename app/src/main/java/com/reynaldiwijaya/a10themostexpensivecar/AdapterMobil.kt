package com.reynaldiwijaya.a10themostexpensivecar

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_mobil.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class AdapterMobil (val context: Context, val items: List<Item>, var listener: (Item) -> Unit): RecyclerView.Adapter<AdapterMobil.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_mobil, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(items[position], listener)
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder (view) {
        val tittleMobil = view.txtTitleMobil
        val gambarMobil = view.imgMobil

        fun bindItem (item: Item, listener: (Item) -> Unit){
            tittleMobil.text = item.nama
            Glide.with(itemView.context).load(item.gambar).into(gambarMobil)
            itemView.onClick {
                listener(item)
            }
        }
    }

}