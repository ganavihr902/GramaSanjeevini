package com.example.gramasanjeevini.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.gramasanjeevini.R

class SearchMedicineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_search_medicine
        )

        val medicineEt =
            findViewById<EditText>(
                R.id.medicineEt
            )

        val searchBtn =
            findViewById<Button>(
                R.id.searchBtn
            )

        searchBtn.setOnClickListener {

            val medicineName =
                medicineEt.text.toString()

            val intent = Intent(
                this,
                ResultActivity::class.java
            )

            intent.putExtra(
                "medicineName",
                medicineName
            )

            startActivity(intent)
        }
    }
}