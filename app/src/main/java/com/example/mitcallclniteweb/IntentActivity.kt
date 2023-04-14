package com.example.mitcallclniteweb

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    // sms,call,dial,share,camera,stk(mpesa)
    lateinit var buttonsms:Button
    lateinit var buttoncall:Button
    lateinit var buttondial:Button
    lateinit var buttonshare:Button
    lateinit var buttoncamera:Button
    lateinit var buttonstk:Button
    lateinit var buttonemail:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        buttonsms=findViewById(R.id.Btn_sms)
        buttoncall=findViewById(R.id.Btn_call)
        buttondial=findViewById(R.id.Btn_dial)
        buttonshare=findViewById(R.id.Btn_share)
        buttoncamera=findViewById(R.id.Btn_camera)
        buttonstk=findViewById(R.id.Btn_stk)
        buttonemail=findViewById(R.id.Btn_email)

        buttonsms.setOnClickListener { it view!
            val uri = Uri.parse("smsto:07456789")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("Hello", "How is todays weather")

            startActivity(intent)
        }

        }
        buttoncall.setOnClickListener { it view!
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

        if (ContextCompat.checkSelfPermission(
                this@IntentActivity,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this@IntentActivity,
                arrayOf(Manifest.permission.CALL_PHONE),
                1
            )
        } else {
            startActivity(intent)
        }

        }
        buttondial.setOnClickListener { it view!
        val phone = "+34666777888"

        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

        startActivity(intent)

        }
        buttonshare.setOnClickListener { it view!
        val shareIntent = Intent(Intent.ACTION_SEND)

        shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        shareIntent.type = "text/plain"

        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

        startActivity(shareIntent)

        }
        buttoncamera.setOnClickListener { it view!
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        startActivityForResult(takePictureIntent, 1)

        }
        buttonstk.setOnClickListener { it view!
        val simToolKitLaunchIntent =
            applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

        simToolKitLaunchIntent?.let { startActivity(it) }


    }
        buttonemail.setOnClickListener { it view!

        val emailIntent =
            Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

        startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }

    }
}