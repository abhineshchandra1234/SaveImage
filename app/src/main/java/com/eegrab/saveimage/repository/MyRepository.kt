package com.eegrab.saveimage.repository

import androidx.lifecycle.LiveData
import com.eegrab.saveimage.data.MyDao
import com.eegrab.saveimage.data.Person

class MyRepository(private val myDao: MyDao) {

    val readPerson: LiveData<List<Person>> = myDao.readPerson()

    suspend fun insertPerson(person: Person){
        myDao.insertPerson(person)
    }

}