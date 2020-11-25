package com.example.vectoreditor

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.devs.vectorchildfinder.VectorChildFinder
import com.devs.vectorchildfinder.VectorDrawableCompat

class MainActivity : AppCompatActivity() {
    private var dressPath: VectorDrawableCompat.VFullPath? = null
    private var mouthGroup: VectorDrawableCompat.VGroup? = null
    private var eyesGroup: VectorDrawableCompat.VGroup? = null
    private var image: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image = findViewById(R.id.image)
        val vector = VectorChildFinder(
            this,
            R.drawable.boy, image
        )
        dressPath = vector.findPathByName("dress_path")
        mouthGroup = vector.findGroupByName("mouth_group")
        eyesGroup = vector.findGroupByName("eyes_group")
    }

    private var e = true
    private var m = true
    fun onButtonClick(view: View) {
        when (view.id) {
            R.id.button1 -> dressPath!!.fillColor =
                resources.getColor(android.R.color.holo_red_light)
            R.id.button2 -> dressPath!!.fillColor =
                resources.getColor(android.R.color.holo_green_dark)
            R.id.button3 -> dressPath!!.fillColor =
                resources.getColor(android.R.color.holo_blue_dark)
            R.id.button4 -> dressPath!!.fillColor = resources.getColor(android.R.color.holo_purple)
            R.id.btn_eyes -> if (e) {
                e = false
                eyesGroup?.translateX = -10f
            } else {
                e = true
                eyesGroup?.translateX = 0f
            }
            R.id.btn_mouth -> if (m) {
                m = false
                mouthGroup?.translateX = -10f
            } else {
                m = true
                mouthGroup?.translateX = 0f
            }
        }
        image?.invalidate()
    }
}