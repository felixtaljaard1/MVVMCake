package com.example.pacticemvvm.repository

import com.example.pacticemvvm.model.RetrofitServiceItem
import com.example.pacticemvvm.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllCakeAPI() = retrofitService.getCakeListService()
}