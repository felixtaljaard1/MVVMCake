package com.example.pacticemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pacticemvvm.model.RetrofitServiceItem
import com.example.pacticemvvm.repository.MainRepository
import kotlinx.coroutines.*

class MainViewModel constructor (private val repository: MainRepository): ViewModel(){

    val errorMsg = MutableLiveData<String>()
    val respData = MutableLiveData<List<RetrofitServiceItem>>()
    var job: Job? = null

    fun getCakeDataFromVM(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getAllCakeAPI()
            withContext(Dispatchers.Main){
                respData.postValue(response.body())
            }
        }
    }
}