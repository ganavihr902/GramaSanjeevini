package com.example.gramasanjeevini.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gramasanjeevini.R

class MedicineDetailsActivity :
    AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_medicine_details
        )

        val medicineNameTv =
            findViewById<TextView>(
                R.id.medicineNameTv
            )

        val shopNameTv =
            findViewById<TextView>(
                R.id.shopNameTv
            )

        val expiryDateTv =
            findViewById<TextView>(
                R.id.expiryDateTv
            )

        val stockTv =
            findViewById<TextView>(
                R.id.stockTv
            )

        val villageTv =
            findViewById<TextView>(
                R.id.villageTv
            )

        val name =
            intent.getStringExtra("name")

        val shopName =
            intent.getStringExtra("shopName")

        val expiryDate =
            intent.getStringExtra("expiryDate")

        val stock =
            intent.getLongExtra("stock", 0)

        val village =
            intent.getStringExtra("village")

        medicineNameTv.text =
            "Medicine Name : $name"

        shopNameTv.text =
            "Shop Name : $shopName"

        expiryDateTv.text =
            "Expiry Date : $expiryDate"

        stockTv.text =
            "Available Stock : $stock"

        villageTv.text =
            "Village : $village"
    }
}