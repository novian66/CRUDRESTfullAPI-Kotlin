package com.novian.crudrestfullapiclient.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.novian.crudrestfullapiclient.R

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val REQUEST_CODE = "requestCode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
