package com.example.pacticemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pacticemvvm.adapter.CakeAdapter
import com.example.pacticemvvm.databinding.ActivityMainBinding
import com.example.pacticemvvm.databinding.RowCakeBinding
import com.example.pacticemvvm.network.RetrofitService
import com.example.pacticemvvm.repository.MainRepository
import com.example.pacticemvvm.viewmodel.MainViewModel
import com.example.pacticemvvm.viewmodel.MyViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    // private lateinit var viewModel: MainViewModel
    private val viewModel by viewModels<MainViewModel>()

    private lateinit var activityBinding: ActivityMainBinding
    private val cakeAdapter = CakeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityBinding.root)

        activityBinding.recyclerView.adapter = cakeAdapter
        activityBinding.recyclerView.layoutManager = LinearLayoutManager(this)

        initializeService()
        callService()
        getDataToDisplay()
    }

    fun initializeService(){
//        val retrofitService= RetrofitService.getRetrofitInstance()
//        val repository= MainRepository(retrofitService)
//        viewModel = ViewModelProvider(this, MyViewModelFactory(repository)).get(MainViewModel::class.java)
    }

    fun callService(){
        viewModel.getCakeDataFromVM()
    }

    fun getDataToDisplay(){
        viewModel.respData.observe(this){
            Log.i("Cake", it.get(0).title)

            cakeAdapter.submitList(it)
        }
    }
}