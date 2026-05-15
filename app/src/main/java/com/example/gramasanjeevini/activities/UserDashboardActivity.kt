package com.example.gramasanjeevini.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.gramasanjeevini.R

class UserDashboardActivity :
    AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_user_dashboard
        )

        val searchBtn =
            findViewById<Button>(R.id.searchBtn)

        searchBtn.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    SearchMedicineActivity::class.java
                )
            )
        }
    }
}