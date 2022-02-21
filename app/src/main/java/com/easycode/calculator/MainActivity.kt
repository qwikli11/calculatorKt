package com.easycode.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var isChar = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        init()


    }

    fun init() {

        screen.movementMethod = ScrollingMovementMethod()
        button_1.setOnClickListener(this)
        button_2.setOnClickListener(this)
        button_3.setOnClickListener(this)
        button_4.setOnClickListener(this)
        button_5.setOnClickListener(this)
        button_6.setOnClickListener(this)
        button_7.setOnClickListener(this)
        button_8.setOnClickListener(this)
        button_9.setOnClickListener(this)
        button_0.setOnClickListener(this)
        clear.setOnClickListener(this)
        del.setOnClickListener(this)
        percent.setOnClickListener(this)
        divide.setOnClickListener(this)
        multiply.setOnClickListener(this)
        subtract.setOnClickListener(this)
        fold.setOnClickListener(this)
        equals.setOnClickListener(this)

    }

    fun scroll() {

        val scrollAmount = screen.layout.getLineTop(screen.lineCount) - screen.height;

        if (scrollAmount > 0) {
            screen.scrollTo(0, scrollAmount)
        } else {
            screen.scrollTo(0, 0)
        }

    }

    fun setText(text: String) {
        screen.append(text)
        scroll()
    }

    override fun onClick(it: View?) {
        val btn = it as Button
        when (it?.id) {
            R.id.button_1,
            R.id.button_2,
            R.id.button_3,
            R.id.button_4,
            R.id.button_5,
            R.id.button_6,
            R.id.button_7,
            R.id.button_8,
            R.id.button_9,
            R.id.button_0,
            -> {
                setText(btn.text as String)
            }
            R.id.clear -> {
                screen.text = ""
            }
            R.id.del -> {
                if (screen.text.length > 0) {
                    screen.text = screen.text.subSequence(0, screen.text.length - 1)
                }
            }
            R.id.equals -> {
                setText("${btn.text}\n")
            }
            R.id.percent,
            R.id.divide,
            R.id.multiply,
            R.id.subtract,
            R.id.fold,
            -> {
                val arrySimvol = arrayOf("×", "÷", "−", "+","%")
                val charText : String = screen.text.subSequence(screen.text.length - 1, screen.text.length).toString()

                if(arrySimvol.contains(charText)){
                    screen.text = screen.text.subSequence(0, screen.text.length - 1)
                    setText(btn.text.toString())
                }
                else{
                    isChar = true
                    setText(btn.text.toString())
                }
            }
        }
    }

}


