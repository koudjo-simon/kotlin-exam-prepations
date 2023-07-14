package oks.ro.revision

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SettingActivity : AppCompatActivity() {

    lateinit var textTxt: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        textTxt = findViewById(R.id.sett_text_txt)
        textTxt.text = intent?.getStringExtra("NAME")

    }


}