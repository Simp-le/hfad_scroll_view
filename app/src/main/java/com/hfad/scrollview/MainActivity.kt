package com.hfad.scrollview

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setPaddings(findViewById(R.id.main))
    }

    private fun setPaddings(view: View) {
        val initialPadding = Rect(view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)

        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                bars.left + initialPadding.left,
                bars.top + initialPadding.top,
                bars.right + initialPadding.right,
                bars.bottom + initialPadding.bottom
            )
            insets
        }
    }
}