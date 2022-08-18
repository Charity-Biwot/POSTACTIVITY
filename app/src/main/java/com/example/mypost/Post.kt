package com.example.mypost

data class Post(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String,
    var About: String
)
 class Comment(
    var postId:Int,
    var id: Int,
    name:String,
    var title: String,
    var email:String,
    var body:String
)
fun <T> compareIds(item:T,item2:T):T{
    var output = (item.toString()+item2.toString())
    println(output)
    return item
}
