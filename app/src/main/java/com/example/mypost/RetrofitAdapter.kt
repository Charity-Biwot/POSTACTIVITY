
package com.example.Post

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Post.databinding.PostListXmlBinding
import com.example.mypost.Post
import com.example.mypost.CommentActivity

class RetrofitAdapter(var postList: List<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = PostListXmlBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val context = holder.itemView.context
        var currentPost = postList.get(position)
        holder.binding.tvAbout.text = currentPost.title
        with(holder.binding) {
            tvAbout.text = currentPost.userId.toString()
            userId.text = currentPost.id.toString()
            idNo.text = currentPost.title
            val intent = Intent(context, CommentActivity::class.java)
            intent.putExtra("POST_ID", currentPost.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

}

class PostViewHolder(var binding: PostListXmlBinding) :
    RecyclerView.ViewHolder(binding.root)



