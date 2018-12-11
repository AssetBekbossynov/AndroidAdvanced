package com.example.asset.aalab5

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Service {

    @GET("posts/")
    fun getTodos(): Call<List<Todo>>

    @GET("todos/{id}")
    fun getTodo(@Path("id") id: Int): Call<Todo>

    @POST("posts/")
    fun createPost(@Body post: Post): Call<ResponseBody>
}

