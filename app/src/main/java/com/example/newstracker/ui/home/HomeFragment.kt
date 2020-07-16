package com.example.newstracker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.newstracker.R
import com.example.newstracker.utils.Resource
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.KoinContextHandler.get

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    //private lateinit var data
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        lifecycle.addObserver(homeViewModel)
        return root
    }

    override fun onStart() {
        super.onStart()

        subscribeToLiveData()
    }

    private fun subscribeToLiveData(){
        homeViewModel.everythingNew.observe(this, Observer {
        when(it){
            is Resource.Success ->{Toast.makeText(this.context,"suc"+it.data,Toast.LENGTH_LONG).show()}
            is Resource.Error->{Toast.makeText(this.context,"erro",Toast.LENGTH_LONG).show()}
            is Resource.Loading->{Toast.makeText(this.context,"load",Toast.LENGTH_LONG).show()}
        }
        }
        )
    }
}