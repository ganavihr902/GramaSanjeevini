package com.example.gramasanjeevini.activities.repository

import com.example.gramasanjeevini.models.Medicine
import com.example.gramasanjeevini.models.User
import com.example.gramasanjeevini.models.Pharmacist
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRepository {

    private val db =
        FirebaseFirestore.getInstance()

    fun uploadMedicine(
        medicine: Medicine
    ) {

        db.collection("medicines")
            .add(medicine)
    }

    fun getMedicines() =
        db.collection("medicines")
}