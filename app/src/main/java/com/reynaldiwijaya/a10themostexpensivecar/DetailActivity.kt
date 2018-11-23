package com.reynaldiwijaya.a10themostexpensivecar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var namaMobil = intent.getStringExtra("namaMobil")
        var detailMobil = intent.getStringExtra("detailMobil")
        var gambarMobil = intent.getIntExtra("gambarMobil",0)

        txtMobilNameDetail.text = namaMobil
        txtDetaiMobil.text = detailMobil
        Glide.with(this).load(gambarMobil).into(imgMobilDetail)
    }
}
