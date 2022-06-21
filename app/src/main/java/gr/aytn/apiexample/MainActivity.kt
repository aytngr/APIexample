package gr.aytn.apiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import gr.aytn.apiexample.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAPIService:APIService
    var tvResult: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val root: View = binding.root
        setContentView(root)

        mAPIService = ApiUtils().getAPIService()!!

        var etCustomer: EditText = binding.customer
        var etQuantity: EditText = binding.quantity
        var etPrice: EditText = binding.price
        var btnPost: Button = binding.btnPost
        tvResult = binding.tvResult

        btnPost.setOnClickListener {
            var customer = etCustomer.text.toString()
            var quantity = etQuantity.text.toString().toInt()
            var price = etPrice.text.toString().toDouble()
            sendPost(1111,customer,quantity,price)
        }

    }
    fun sendPost(id:Int,customer:String,quantity:Int, price:Double){
        mAPIService.savePost(id,customer,quantity,price).enqueue(object: Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if (response.isSuccessful()){
                    showResponse(response.body().toString())
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                tvResult?.text = "Unable to submit post to API."
            }

        })
    }
    fun showResponse(response:String){
        tvResult?.text = response
    }

}