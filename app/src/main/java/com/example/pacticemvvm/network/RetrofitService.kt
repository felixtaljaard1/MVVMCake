package com.example.pacticemvvm.network

import com.example.pacticemvvm.model.RetrofitServiceItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    /**
     * Configure GET REST webservice
     * Configure Retrofit object: Builder pattern
     */
    // perfrom network request - separate thread - coroutines
    // [] = List, {} = dataclass name
    @GET(APIEndpoints.API_CAKE_LIST)
    suspend fun getCakeListService() : Response<List<RetrofitServiceItem>>

//    companion object{
//        var retrofitService: RetrofitService?=null
//
//        fun getRetrofitInstance() : RetrofitService{
//            if(retrofitService==null){
//                val retrofit = Retrofit.Builder()
//                    .baseUrl(APIEndpoints.BASE_URL) // link to get data
//                    .addConverterFactory(GsonConverterFactory.create()) //JSON response to kotlin
//                    .build()
//                retrofitService = retrofit.create(RetrofitService::class.java)
//            }
//            return retrofitService!!
//        }
//    }
}