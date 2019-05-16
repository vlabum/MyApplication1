package ru.vlabum.android.myapplication1

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var repo: MainRepo = MainRepo()

    private val veiwHelloWorld: MutableLiveData<String> = MutableLiveData()

    private val veiwSaved: MutableLiveData<String> = MutableLiveData()

    init {
        veiwHelloWorld.value = repo.getHello()
    }

    fun viewHelloWorld(): LiveData<String> = veiwHelloWorld

    fun viewSavedText(): LiveData<String> = veiwSaved

    fun setSave(text: String?) {
        repo.setSaved(text)
        veiwSaved.value = repo.getSaved()
    }

}