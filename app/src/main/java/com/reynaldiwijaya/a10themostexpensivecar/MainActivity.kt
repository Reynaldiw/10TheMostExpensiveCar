package com.reynaldiwijaya.a10themostexpensivecar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var namaMobil = resources.getStringArray(R.array.namaMobil)
        var detailMobil = resources.getStringArray(R.array.namaDetail)
        var gambarMobil = resources.obtainTypedArray(R.array.gambarMobil)

        for (i in namaMobil.indices){
            items.add(Item(namaMobil[i], gambarMobil.getResourceId(i, 0), detailMobil[i]))
        }

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = AdapterMobil(this, items){
            startActivity<DetailActivity>("namaMobil" to it.nama, "detailMobil" to it.detail, "gambarMobil" to it.gambar)
        }
    }
}
