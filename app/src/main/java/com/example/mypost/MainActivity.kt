package com.example.mypost
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Post.RetrofitAdapter
import com.example.Post.databinding.ActivityMainBinding
import com.example.mypost.ApiClient
import com.example.mypost.ApiInterface
import com.example.mypost.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPost()
    }
    fun getPost(){
        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getPosts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    var posts = response.body()
                    Toast.makeText(baseContext, "fetched ${posts!!.size} post",
                        Toast.LENGTH_LONG).show()


                    var postAdapter = RetrofitAdapter(posts)
                    binding.rvPosts.layoutManager= LinearLayoutManager(baseContext)
                    binding.rvPosts.adapter  = postAdapter
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }




}










