package com.appsian.fitstopwatch

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var atg: Animation
    lateinit var btgOne: Animation
    lateinit var btgTwo: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mLight = Typeface.createFromAsset(assets, "fonts/MLight.ttf")
        val mMedium = Typeface.createFromAsset(assets, "fonts/MMedium.ttf")
        val mRegular = Typeface.createFromAsset(assets, "fonts/MRegular.ttf")
//load atg
        atg = AnimationUtils.loadAnimation(this, R.anim.atg)
        btgOne = AnimationUtils.loadAnimation(this, R.anim.btg_one)
        btgTwo = AnimationUtils.loadAnimation(this, R.anim.btg_two)


        btnGet.setOnClickListener {
            val a = Intent(this,StopWatchActivity::class.java)
            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(a)
        }

        ivSplash.startAnimation(atg)
        tvSplash.startAnimation(btgOne)
        tvSubSplash.startAnimation(btgOne)
        btnGet.startAnimation(btgTwo)
        tvSplash.typeface = mRegular
        tvSubSplash.typeface = mLight
        btnGet.typeface = mMedium
    }
}
