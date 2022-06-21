package gr.aytn.apiexample

class ApiUtils {
    val BASE_URL:String = "https://reqbin.com/echo/post/"

    fun getAPIService(): APIService?{
        return RetrofitClient().getClient(BASE_URL)?.create(APIService::class.java)
    }
}