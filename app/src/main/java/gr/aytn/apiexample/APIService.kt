package gr.aytn.apiexample

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService {
    @FormUrlEncoded
    @POST("json")
    fun savePost(@Field("Id") Id:Int,
                 @Field("Customer") Customer:String,
                 @Field("Quantity") Quantity:Int,
                 @Field("Price") Price:Double) : Call<PostResponse>
}