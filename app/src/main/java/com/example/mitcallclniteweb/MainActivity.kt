package com.example.mitcallclniteweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var buttoncal:Button
    lateinit var buttonint:Button
    lateinit var buttonweb:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttoncal=findViewById(R.id.Btn_Calc)
        buttonint=findViewById(R.id.Btn_Intent)
        buttonweb=findViewById(R.id.Btn_web)

        buttoncal.setOnClickListener { it:View!
                val calc = Intent(PackageContext: this, CalcActivity::class.java)
                startActivity(calc)
        }
        buttonint.setOnClickListener { it:View!
                var int = Intent(
                    packageContext: this, IntentActivity::class.java
                )
            startActivity()
        }
        buttonweb.setOnClickListener { it:view!
                var web=Intent(packageContext: this,WebActivity::class.java)
                startActivity(web)
        }
    }
}