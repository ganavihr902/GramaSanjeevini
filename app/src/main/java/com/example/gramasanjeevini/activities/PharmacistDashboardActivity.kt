package com.example.gramasanjeevini.activities

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.gramasanjeevini.R
import com.example.gramasanjeevini.models.Medicine
import com.google.firebase.firestore.FirebaseFirestore

class PharmacistDashboardActivity :
    AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_pharmacist_dashboard
        )

        db = FirebaseFirestore.getInstance()

        val medicineNameEt =
            findViewById<EditText>(R.id.medicineNameEt)

        val shopNameEt =
            findViewById<EditText>(R.id.shopNameEt)

        val expiryDateEt =
            findViewById<EditText>(R.id.expiryDateEt)

        val stockEt =
            findViewById<EditText>(R.id.stockEt)

        val villageEt =
            findViewById<EditText>(R.id.villageEt)

        val uploadBtn =
            findViewById<Button>(R.id.uploadBtn)

        uploadBtn.setOnClickListener {

            val medicine = Medicine(

                name =
                    medicineNameEt.text.toString(),

                shopName =
                    shopNameEt.text.toString(),

                expiryDate =
                    expiryDateEt.text.toString(),

                stock =
                    stockEt.text.toString().toLong(),

                village =
                    villageEt.text.toString()
            )

            db.collection("medicines")
                .add(medicine)

            Toast.makeText(
                this,
                "Medicine Uploaded",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}