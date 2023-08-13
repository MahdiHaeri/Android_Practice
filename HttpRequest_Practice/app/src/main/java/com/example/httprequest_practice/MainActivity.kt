package com.example.httprequest_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    private val url = "https://jsonplaceholder.typicode.com/posts"
    private var volleyRequest: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        volleyRequest = Volley.newRequestQueue(this)
        getResponse(url)
    }

    fun getResponse(url: String) {
        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            println(response)
        }, { error ->
            println(error)
        })
        volleyRequest?.add(stringRequest)
    }
}