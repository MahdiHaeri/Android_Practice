package com.example.httprequest_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private val url = "https://jsonplaceholder.typicode.com/posts"
    private var volleyRequest: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        volleyRequest = Volley.newRequestQueue(this)
//        getStringResponse(url)
        getJsonArrayResponse(url)
    }

    fun getJsonArrayResponse(url: String) {
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, { response: JSONArray ->
            for (i in 0 until response.length()) {
                val jsonObject = response.getJSONObject(i)
                if (jsonObject.has("title")) {
                    val title = jsonObject.getString("title")
                    println(title)
                } else {
                    println("No title")
                }
            }
        }, { error ->
            println(error)
        })
        volleyRequest?.add(jsonArrayRequest)
    }

    fun getStringResponse(url: String) {
        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            println(response)
        }, { error ->
            println(error)
        })
        volleyRequest?.add(stringRequest)
    }
}