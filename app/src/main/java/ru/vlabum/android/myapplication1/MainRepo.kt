package ru.vlabum.android.myapplication1

class MainRepo() {

    var mainData: MainData = MainData

    fun getHello(): String {
        return mainData.hello
    }

    fun getSaved(): String? {
        return mainData.savedText
    }

    fun setSaved(text: String?) {
        mainData.savedText = text
    }

}