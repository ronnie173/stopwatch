package com.appsian.fitstopwatch

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Chronometer
import kotlinx.android.synthetic.main.activity_stop_watch.*

class StopWatchActivity : AppCompatActivity() {

    lateinit var roundingalone: Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)
//create optional animation
        btnStop.alpha = 0f
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone)


        val mMedium = Typeface.createFromAsset(assets, "fonts/MMedium.ttf")


        btnStart.setTypeface(mMedium)

        btnStart.setOnClickListener {
            icanchor.startAnimation(roundingalone)
            btnStop.animate().alpha(1f).translationY(-80f).setDuration(300).start()
            btnStart.animate().alpha(0f).setDuration(300).start()

            //start the timer
            timer.base = SystemClock.elapsedRealtime()
            timer.start()
        }


    }
}
