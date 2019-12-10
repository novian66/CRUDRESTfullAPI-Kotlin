package com.novian.crudrestfullapiclient.api

import com.novian.crudrestfullapiclient.CoroutineContextProvider
import com.novian.crudrestfullapiclient.MainView
import com.novian.crudrestfullapiclient.model.Message
import com.novian.crudrestfullapiclient.model.QuoteResponse
import com.novian.crudrestfullapiclient.model.StudentResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter (private val view: MainView,
                     private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getDetailStudent(nim:String) {
        view.showLoading()
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.getStudentByNim(nim).enqueue(object :
                    Callback<StudentResponse> {
                    override fun onResponse(
                        call: Call<StudentResponse>,
                        response: Response<StudentResponse>
                    ) {
                        if(response.code() == 200) {
                            response.body()?.student?.let {
                                view.resultStudent(it)
                                view.hideLoading()
                            }
                        }
                    }
                    override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }

    fun getMyQuotes(nim:String) {
        view.showLoading()
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.getMyQuotes(nim).enqueue(object :
                    Callback<QuoteResponse> {
                    override fun onResponse(
                        call: Call<QuoteResponse>,
                        response: Response<QuoteResponse>
                    ) {
                        if(response.code() == 200) {
                            response.body()?.quotes?.let {
                                view.resultQuote(it)
                                view.hideLoading()
                            }
                        }
                    }
                    override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun getAllQuotes() {
        view.showLoading()
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.getAllQuotes().enqueue(object :
                    Callback<QuoteResponse> {
                    override fun onResponse(
                        call: Call<QuoteResponse>,
                        response: Response<QuoteResponse>
                    ) {
                        if(response.code() == 200) {
                            response.body()?.quotes?.let {
                                view.resultQuote(it)
                                view.hideLoading()
                            }
                        }
                    }
                    override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun addQuote(student_id:String, title:String, description: String) {
        view.showLoading()
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.addQuote(student_id,title,description).enqueue(object :
                    Callback<Message> {
                    override fun onResponse(
                        call: Call<Message>,
                        response: Response<Message>
                    ) {
                        if(response.code() == 200) {
                            response.body()?.message?.let {
                                view.resultAction(it)
                                view.hideLoading()
                            }
                        }
                    }
                    override fun onFailure(call: Call<Message>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                        view.hideLoading()
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun updateQuote(quote_id:String, title:String, description: String) {
        view.showLoading()
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.updateQuote(quote_id,title,description).enqueue(object :
                    Callback<Message> {
                    override fun onResponse(
                        call: Call<Message>,
                        response: Response<Message>
                    ) {
                        if(response.code() == 200) {
                            response.body()?.message?.let {
                                view.resultAction(it)
                                view.hideLoading()
                            }
                        }
                    }
                    override fun onFailure(call: Call<Message>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                        view.hideLoading()
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun deleteQuote(quote_id: String) {
        view.showLoading()
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.deleteQuote(quote_id).enqueue(object :
                    Callback<Message> {
                    override fun onResponse(
                        call: Call<Message>,
                        response: Response<Message>
                    ) {
                        if(response.code() == 200) {
                            response.body()?.message?.let {
                                view.resultAction(it)
                                view.hideLoading()
                            }
                        }
                    }
                    override fun onFailure(call: Call<Message>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                        view.hideLoading()
                    }
                })
            }
            catch (e:Exception){
            }
            view.resultAction("Reloaded")
        }
    }
}
