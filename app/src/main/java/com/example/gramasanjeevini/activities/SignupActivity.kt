package com.example.gramasanjeevini.activities

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.gramasanjeevini.R
import com.example.gramasanjeevini.models.Pharmacist
import com.example.gramasanjeevini.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val emailEt =
            findViewById<EditText>(R.id.emailEt)

        val passwordEt =
            findViewById<EditText>(R.id.passwordEt)

        val villageEt =
            findViewById<EditText>(R.id.villageEt)

        val userNameEt =
            findViewById<EditText>(R.id.userNameEt)

        val shopNameEt =
            findViewById<EditText>(R.id.shopNameEt)

        val roleSpinner =
            findViewById<Spinner>(R.id.roleSpinner)

        val signupBtn =
            findViewById<Button>(R.id.signupBtn)

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

        signupBtn.setOnClickListener {

            val email =
                emailEt.text.toString()

            val password =
                passwordEt.text.toString()

            val village =
                villageEt.text.toString()

            val userName =
                userNameEt.text.toString()

            val shopName =
                shopNameEt.text.toString()

            val role =
                roleSpinner.selectedItem.toString()

            if (
                email.isEmpty() ||
                password.isEmpty() ||
                village.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(
                email,
                password
            ).addOnSuccessListener {

                val uid =
                    auth.currentUser?.uid ?: ""

                if (role == "User") {

                    val user = User(
                        uid,
                        email,
                        role,
                        village
                    )

                    db.collection("users")
                        .document(uid)
                        .set(user)

                } else {

                    val pharmacist = Pharmacist(
                        uid,
                        userName,
                        email,
                        shopName,
                        village,
                        role
                    )

                    db.collection("pharmacists")
                        .document(uid)
                        .set(pharmacist)
                }

                Toast.makeText(
                    this,
                    "Account Created Successfully",
                    Toast.LENGTH_LONG
                ).show()

                startActivity(
                    Intent(
                        this,
                        LoginActivity::class.java
                    )
                )

                finish()

            }.addOnFailureListener {

                Toast.makeText(
                    this,
                    it.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}