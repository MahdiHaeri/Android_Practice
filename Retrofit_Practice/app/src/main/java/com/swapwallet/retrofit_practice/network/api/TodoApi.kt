package com.swapwallet.retrofit_practice.network.api

import com.swapwallet.retrofit_practice.model.Todo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TodoApi {

    @GET(value = "/todos")
    suspend fun getTodos(): Response<List<Todo>>

    @POST(value = "/todos")
    suspend fun postTodos(@Body todo: Todo): Response<Todo>
}