package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.viewmodel.TestViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  viewModel :TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this ). get(TestViewModel :: class.java)

        viewModel.currentNumber.observe( this, Observer{
            textView2.text = it.toString()

        })

        viewModel.currentBoolean.observe( this, Observer{
            textView.text = it.toString()

        })
        incrementText()
    }
    private  fun  incrementText(){
        button.setOnClickListener{
            viewModel.currentNumber.value =++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0

        }
    }
}