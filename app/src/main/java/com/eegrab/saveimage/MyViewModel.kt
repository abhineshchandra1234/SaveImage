package com.eegrab.saveimage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.eegrab.saveimage.data.MyDatabase
import com.eegrab.saveimage.data.Person
import com.eegrab.saveimage.repository.MyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application): AndroidViewModel(application) {

    private val dao = MyDatabase.getDatabase(application).myDao()
    private val repository = MyRepository(dao)

    val readPerson: LiveData<List<Person>> = repository.readPerson

    fun insertPerson(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPerson(person)
        }
    }

}