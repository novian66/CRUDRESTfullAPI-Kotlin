package com.novian.crudrestfullapiclient.api

import com.novian.crudrestfullapiclient.model.Message
import com.novian.crudrestfullapiclient.model.QuoteResponse
import com.novian.crudrestfullapiclient.model.StudentResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @GET("student/q/nim/{nim}")
    fun getStudentByNim(@Path("nim") nim: String): Call<StudentResponse>
    @GET("quotes/q/my_quote/{nim}")
    fun getMyQuotes(@Path("nim") nim:String): Call<QuoteResponse>
    @GET("quotes/q/class_id/{class_id}")
    fun getClassQuotes(@Path("class_id") class_id:String): Call<QuoteResponse>
    @GET("quotes/")
    fun getAllQuotes(): Call<QuoteResponse>
    @POST("quotes/")
    @FormUrlEncoded
    fun addQuote(
        @Field("student_id") class_id: String,
        @Field("title") title: String,
        @Field("description") description: String
    ): Call<Message>
    @PUT("quotes/")
    @FormUrlEncoded
    fun updateQuote(
        @Field("quote_id") quote_id: String,
        @Field("title") title: String,
        @Field("description") description: String
    ): Call<Message>
    @DELETE("quotes/q/quote_id/{quote_id}")
    fun deleteQuote(
        @Path("quote_id") quote_id: String
    ): Call<Message>
}
