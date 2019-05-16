package ru.vlabum.android.myapplication1

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.viewHelloWorld().observe(this, Observer { value ->
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
        })
        viewModel.viewSavedText().observe(this, Observer { value ->
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
            textView2.text = value
        })
    }

    fun clickListener(v: View) {
        viewModel.setSave(editText2.text.toString())
    }
}
