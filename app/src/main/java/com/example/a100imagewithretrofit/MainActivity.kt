package com.example.a100imagewithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a100imagewithretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.recyclerViewMain.layoutManager = GridLayoutManager(this,3)
        fetchJson()
    }

    private fun fetchJson() {
        NetworkManager.service.getImage(
            "1c04e05bce6e626247758d120b372a73",
            "flickr.photos.getRecent",
            "url_s",
            "json",
            "1",
            "100",
            "1"
        ).enqueue(object : Callback<FlickrResult> {
            override fun onResponse(call: Call<FlickrResult>, response: Response<FlickrResult>) {
                Log.d("Tag", response.body().toString())
                Log.d("Tag", "success")
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_main)
                recyclerView.adapter = RecyclerAdapter(response.body()!!)
            }

            override fun onFailure(call: Call<FlickrResult>, t: Throwable) {
                Log.d("Tag", t.message.toString())
                Log.d("Tag", "Failure")
            }
        })
    }
}