package com.novian.crudrestfullapiclient.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.novian.crudrestfullapiclient.R
import com.novian.crudrestfullapiclient.model.Quote



class GlobalQuotesAdapter(private val list: List<Quote>, val context: Context) :
    RecyclerView.Adapter<GlobalQuotesAdapter.BookViewHolder>() {



    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val myData = list[position]

        holder.titleQuote.text = myData.title
        holder.created.text = "Dibuat pada :"+myData.created
        holder.updated.text = "Diubah pada :"+myData.updated
        holder.quote.text = myData.description
        holder.studentInfo.text = myData.name + " | " + myData.className
        Log.d("quote",myData.title.toString())
        Log.d("quote",myData.image.toString())
        Glide.with(holder.itemView.context)
            .load(myData.image.toString())
            .apply(RequestOptions())
            .into(holder.imageQuote)
        holder.itemView.setOnClickListener {
            val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MYDATA, myData)
            context.startActivity(moveWithObjectIntent)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        return BookViewHolder(view)
    }



    override fun getItemCount(): Int = list.size



    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleQuote: TextView = itemView.findViewById(R.id.tv_title_quote)
        var created: TextView = itemView.findViewById(R.id.tv_created)
        var updated: TextView = itemView.findViewById(R.id.tv_updated)
        var quote: TextView = itemView.findViewById(R.id.tv_quote)
        var studentInfo: TextView = itemView.findViewById(R.id.tv_student_info)
        var imageQuote: ImageView = itemView.findViewById(R.id.image_quote)
    }
}