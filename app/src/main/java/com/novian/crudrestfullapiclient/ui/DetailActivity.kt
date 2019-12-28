package com.novian.crudrestfullapiclient.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.novian.crudrestfullapiclient.R
import com.novian.crudrestfullapiclient.model.Quote
import kotlinx.android.synthetic.main.item_quote.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MYDATA = "extra_data"
        const val REQUEST_CODE = "requestCode"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val myData = intent.getParcelableExtra(InputQuotesActivity.EXTRA_DATA) as? Quote
        tv_title_quote.text= myData!!.title
        tv_quote.text= myData!!.description
        Glide.with(this).load(myData!!.image).into(image_quote)
        tv_student_info.text= myData!!.name + " | " + myData.className
        tv_created.text= "Dibuat pada :"+myData!!.created
        tv_updated.text= "Diubah pada :"+myData!!.updated
    }
}
