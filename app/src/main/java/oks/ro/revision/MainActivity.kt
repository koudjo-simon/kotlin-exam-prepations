package oks.ro.revision

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var helloTxt: TextView
    lateinit var validerBtn: Button
    lateinit var sharePref: SharedPreferences
    lateinit var studentRcv: RecyclerView
    lateinit var studentList: ArrayList<Student>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharePref = getSharedPreferences("FIRSTLOGINSHAREPREF", MODE_PRIVATE)

        if (!sharePref.contains("LOGIN")){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        studentRcv = findViewById(R.id.student_rcv)
        studentList = ArrayList()

        for (i in 1 .. 50){
            studentList.add(Student("Etudiant $i", "etudiant$i@gmail.com","+2289712231$i"))
        }

        val adapter = StudentAdapter(studentList)
        studentRcv.layoutManager = LinearLayoutManager(this)
        studentRcv.adapter = adapter

    }
}