package com.matejdro.imagewriter

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.core.graphics.BitmapCompat
import androidx.core.graphics.set
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.red_button).setOnClickListener {
            writeImage(Color.RED)
        }

        findViewById<Button>(R.id.blue_button).setOnClickListener {
            writeImage(Color.BLUE)
        }
    }

    private fun writeImage(@ColorInt color: Int) {
        val bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888)

        for (y in 0 until 100) {
            for (x in 0 until 100) {
                bitmap.set(x, y, color)
            }
        }

        val file = File(filesDir, "image.png")

        FileOutputStream(file).use {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
        }
    }
}