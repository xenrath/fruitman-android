package com.xenrath.fruitman_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CreateProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_product)

        supportActionBar!!.hide()
    }
}