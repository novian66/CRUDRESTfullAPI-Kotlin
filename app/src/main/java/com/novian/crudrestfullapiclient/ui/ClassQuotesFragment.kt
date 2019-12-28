package com.novian.crudrestfullapiclient.ui


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.novian.crudrestfullapiclient.BuildConfig
import com.novian.crudrestfullapiclient.CoroutineContextProvider
import com.novian.crudrestfullapiclient.MainView
import com.novian.crudrestfullapiclient.R
import com.novian.crudrestfullapiclient.api.MainPresenter
import com.novian.crudrestfullapiclient.model.Quote
import com.novian.crudrestfullapiclient.model.Student
import kotlinx.android.synthetic.main.fragment_quotes.*
import org.jetbrains.anko.support.v4.onRefresh

/**
 * A simple [Fragment] subclass.
 */
class ClassQuotesFragment : Fragment(), MainView {
    override fun resultAction(data: String) {
    }

    override fun showMessage(messsage: String) {
        Toast.makeText(activity!!,messsage, Toast.LENGTH_SHORT).show()
    }

    override fun resultQuote(data: List<Quote>) {
        quotes.clear()
        quotes.addAll(data)
        adapter.notifyDataSetChanged()
        swiperefresh.isRefreshing = false
    }

    override fun resultStudent(data: List<Student>) {
        presenter =
            MainPresenter(this, CoroutineContextProvider())
        data[0].class_id?.let { presenter.getClassQuotes(it) }
    }

    private lateinit var presenter: MainPresenter
    private var quotes: MutableList<Quote> = mutableListOf()
    private lateinit var adapter: ClassQuotesAdapter
    private val addQuoteCode = 1
    private val editQuoteCode = 2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_quotes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerview_global_quotes.layoutManager = LinearLayoutManager(activity)

        adapter = ClassQuotesAdapter(quotes, activity!!)
        recyclerview_global_quotes.adapter = adapter
        presenter =
            MainPresenter(this, CoroutineContextProvider())
        presenter.getDetailStudent(BuildConfig.NIM)
        fab.setOnClickListener { view ->
            val intent = Intent(activity!!, InputQuotesActivity::class.java)
            intent.putExtra(InputQuotesActivity.REQUEST_CODE, addQuoteCode);
            startActivityForResult(intent, addQuoteCode)
        }
        swiperefresh.onRefresh {
            presenter.getDetailStudent(BuildConfig.NIM)
        }

    }

    override fun showLoading() {
        progressbar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressbar.visibility = View.INVISIBLE
    }

    override fun onResume() {
        super.onResume()
        progressbar.visibility = View.INVISIBLE
        presenter.getDetailStudent(BuildConfig.NIM)
    }
}
