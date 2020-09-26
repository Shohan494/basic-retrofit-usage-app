package com.example.laravel8crud

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var t: String = "";


        ApiService.getApiService().reposForUser("azizahmed45").enqueue(object :
            Callback<List<GitHubRepo?>?> {

            override fun onResponse(
                call: Call<List<GitHubRepo?>?>,
                response: Response<List<GitHubRepo?>?>
            ) {

                var data :List<GitHubRepo?>? = response.body()

                data?.forEach {
                    if(it != null){

                        t = t + "\n" + it.name

                        Log.d("Test", it.name)

                    }
                }

                text.setText(t)


            }

            override fun onFailure(
                call: Call<List<GitHubRepo?>?>,
                t: Throwable
            ) {
                Log.d("Test", t.toString())

            }
        })
    }
}