package ru.vlabum.android.myapplication1

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var repo: MainRepo = MainRepo()

    private val viewStateLiveData: MutableLiveData<MainRepo> = MutableLiveData()

    init {
        viewStateLiveData.value = repo
    }

    fun viewState(): LiveData<MainRepo> = viewStateLiveData

    fun setSave(text: String?) {
        repo.setSaved(text)
        // данную штуку воткнул, чтобы наблюдатель увидел, возможно что-то не так сделал
        viewStateLiveData.value = repo
    }

}