package com.example.mypost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Post.PostViewHolder
import com.example.Post.databinding.ActivityCommentBinding

class RetrofitAdaptercomment(var comment:List<Comment>):RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding=ActivityCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComments=comment.get(position)
        with(holder.binding){
            tvPosttittle.text=currentComments.name
            tvPostbody.text=currentComments.body
        }
    }

    override fun getItemCount(): Int {
        return comment.size
    }
}


class CommentsViewHolder(var binding: ActivityCommentBinding):RecyclerView.ViewHolder(binding.root)



