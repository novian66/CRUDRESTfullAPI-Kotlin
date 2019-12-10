package com.novian.crudrestfullapiclient

import com.novian.crudrestfullapiclient.model.Quote
import com.novian.crudrestfullapiclient.model.Student

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(messsage : String)
    fun resultQuote(data: List<Quote>)
    fun resultStudent(data: List<Student>)
    fun resultAction(data: String)
}
