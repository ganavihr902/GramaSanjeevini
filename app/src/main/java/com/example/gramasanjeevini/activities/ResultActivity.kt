package com.example.gramasanjeevini.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gramasanjeevini.R
import com.example.gramasanjeevini.activities.adapter.MedicineAdapter
import com.example.gramasanjeevini.models.Medicine
import com.google.firebase.firestore.FirebaseFirestore

class ResultActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: MedicineAdapter

    private val medicineList =
        ArrayList<Medicine>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)

        recyclerView =
            findViewById(R.id.recyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        adapter = MedicineAdapter(
            this,
            medicineList
        ) { medicine ->

            val intent = Intent(
                this,
                MedicineDetailsActivity::class.java
            )

            intent.putExtra(
                "name",
                medicine.name
            )

            intent.putExtra(
                "shopName",
                medicine.shopName
            )

            intent.putExtra(
                "expiryDate",
                medicine.expiryDate
            )

            intent.putExtra(
                "stock",
                medicine.stock
            )

            intent.putExtra(
                "village",
                medicine.village
            )

            startActivity(intent)
        }

        recyclerView.adapter = adapter

        val medicineName =
            intent.getStringExtra("medicineName")

        FirebaseFirestore.getInstance()
            .collection("medicines")
            .whereEqualTo(
                "name",
                medicineName
            )
            .get()
            .addOnSuccessListener { documents ->

                medicineList.clear()

                for (doc in documents) {

                    val medicine =
                        doc.toObject(
                            Medicine::class.java
                        )

                    medicineList.add(medicine)
                }

                adapter.notifyDataSetChanged()

                if (medicineList.isEmpty()) {

                    Toast.makeText(
                        this,
                        "Medicine Not Available",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }.addOnFailureListener {

                Toast.makeText(
                    this,
                    it.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}