package com.example.gramasanjeevini.activities

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.gramasanjeevini.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val emailEt =
            findViewById<EditText>(R.id.emailEt)

        val passwordEt =
            findViewById<EditText>(R.id.passwordEt)

        val roleSpinner =
            findViewById<Spinner>(R.id.roleSpinner)

        val loginBtn =
            findViewById<Button>(R.id.loginBtn)

        val signupPageBtn =
            findViewById<Button>(R.id.signupPageBtn)

        val roles = arrayOf(
            "User",
            "Pharmacist"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            roles
        )

        roleSpinner.adapter = adapter

        loginBtn.setOnClickListener {

            val email =
                emailEt.text.toString()

            val password =
                passwordEt.text.toString()

            val role =
                roleSpinner.selectedItem.toString()

            if (
                email.isEmpty() ||
                password.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Enter email and password",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(
                email,
                password
            ).addOnSuccessListener {

                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_LONG
                ).show()

                if (role == "User") {

                    startActivity(
                        Intent(
                            this,
                            UserDashboardActivity::class.java
                        )
                    )

                } else {

                    startActivity(
                        Intent(
                            this,
                            PharmacistDashboardActivity::class.java
                        )
                    )
                }

                finish()

            }.addOnFailureListener {

                Toast.makeText(
                    this,
                    "Login Failed: ${it.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        signupPageBtn.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    SignupActivity::class.java
                )
            )
        }
    }
}