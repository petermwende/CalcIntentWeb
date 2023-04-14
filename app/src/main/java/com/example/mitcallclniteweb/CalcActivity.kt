package com.example.mitcallclniteweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalcActivity : AppCompatActivity() {
    lateinit var  Tv_answer:TextView
    lateinit var Edt_firstnumber:EditText
    lateinit var Edt_secondnumber:EditText
    lateinit var buttonadd:Button
    lateinit var buttonsub:Button
    lateinit var buttonmultiply:Button
    lateinit var buttondivide:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        Tv_answer=findViewById(R.id.textView2)
        Edt_firstnumber=findViewById(R.id.Edt_Fnum)
        Edt_secondnumber=findViewById(R.id.Edt_num2)
        buttonadd=findViewById(R.id.Btn_add)
        buttonsub=findViewById(R.id.Btn_sub)
        buttonmultiply=findViewById(R.id.Btn_multiply)
        buttondivide=findViewById(R.id.Btn_divide)

        buttonadd.setOnClickListener { it.view!
            var myfirstnumber=Edt_firstnumber.text.toString()
            var mysecondnumber=Edt_secondnumber.text.toString()
            if (myfirstnumber.isEmpty()&&mysecondnumber.isEmpty()) {
                Tv_answer.text = "Please input all the input"
            }else{
                var answer=myfirstnumber.toDouble() + mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }
        }
        buttonsub.setOnClickListener { it:view!
                var myfirstnumber=Edt_firstnumber.text.toString()
                var mysecondnumber=Edt_secondnumber.text.toString()
                if (myfirstnumber.isEmpty()&&mysecondnumber.isEmpty()) {
                    Tv_answer.text = "Please input all the input"
                }else{
                    var answer=myfirstnumber.toDouble() - mysecondnumber.toDouble()
                    Tv_answer.text=answer.toString()
                }
        }
        buttondivide.setOnClickListener { it: View!
                var myfirstnumber=Edt_firstnumber.text.toString()
                var mysecondnumber=Edt_secondnumber.text.toString()
                if (myfirstnumber.isEmpty()&&mysecondnumber.isEmpty()){
                    Tv_answer.text="Please input all the input"
                }else{
                    var answer=myfirstnumber.toDouble() / mysecondnumber.toDouble()
                    Tv_answer.text=answer.toString()
                }
        }
        buttonmultiply.setOnClickListener { it:view!
                var myfirstnumber=Edt_firstnumber.text.toString()
                var mysecondnumber=Edt_secondnumber.text.toString()
                if (myfirstnumber.isEmpty()&&mysecondnumber.isEmpty()){
                    Tv_answer.text="Please input all the input"
                }else{
                    var answer=myfirstnumber.toDouble() * mysecondnumber.toDouble()
                    Tv_answer.text=answer.toString()
                }
        }
    }
}