package oks.ro.revision

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    lateinit var validerBtn: Button
    lateinit var emailEdt: EditText
    lateinit var passwordEdt: EditText
    lateinit var sharePref: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharePref = getSharedPreferences("FIRSTLOGINSHAREPREF", MODE_PRIVATE)

        validerBtn = findViewById(R.id.login_valider_btn)
        emailEdt = findViewById(R.id.login_email_edt)
        passwordEdt = findViewById(R.id.login_password_edt)
        validerBtn.setOnClickListener {
            if (validerForm()){
                val email = emailEdt.text.toString()
                val password = passwordEdt.text.toString()
                var editor = sharePref.edit()
                editor.putBoolean("LOGIN", true)
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("EMAIL", email)
                intent.putExtra("PASSWORD", password)
                startActivity(intent)
            }
        }
    }

    private fun validerForm(): Boolean {
        var status: Boolean
        val email = emailEdt.text.toString()
        val password = passwordEdt.text.toString()

        if (email.trim().isEmpty()){
            emailEdt.error = "Email is required"
            status = false
        }else {
            emailEdt.error = null
            if (password.trim().isEmpty()){
                passwordEdt.error = "Password is required"
                status = false
            }else {
                passwordEdt.error = null
                status = true
            }
        }
        return status
    }

}