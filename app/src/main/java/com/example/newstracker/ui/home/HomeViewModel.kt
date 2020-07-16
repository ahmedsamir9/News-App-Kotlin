package com.example.newstracker.ui.home

import androidx.lifecycle.*
import com.example.newstracker.data.model.Article
import com.example.newstracker.data.model.NewsResponse
import com.example.newstracker.data.repositaries.HomeRepository
import com.example.newstracker.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel (homeRepository: HomeRepository): ViewModel(),LifecycleObserver{
    private val _homeRepository :HomeRepository = homeRepository
    private val _everythingNew = MutableLiveData<Resource<List<Article>>>()
    val everythingNew: LiveData<Resource<List<Article>>> = _everythingNew
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getEverythingNews(){
        viewModelScope.launch {
            _homeRepository.getAllNews()
                .onStart { _everythingNew.postValue(Resource.Loading())  }
                .flowOn(Dispatchers.IO)
                .catch { error->
                    _everythingNew.postValue(Resource.Error(null,error.toString()))
                }
                .collect {response->
                        _everythingNew.postValue(Resource.Success(response))
                }
        }
    }
}