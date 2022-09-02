package com.example.pacticemvvm.repository

import com.example.pacticemvvm.model.RetrofitServiceItem
import com.example.pacticemvvm.network.RetrofitService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


@ActivityRetainedScoped

class MainRepository @Inject constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllCakeAPI() = retrofitService.getCakeListService()
}