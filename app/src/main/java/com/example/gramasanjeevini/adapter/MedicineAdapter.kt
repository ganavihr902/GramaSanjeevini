package com.example.gramasanjeevini.activities.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.gramasanjeevini.R
import com.example.gramasanjeevini.models.Medicine

class MedicineAdapter(

    private val context: Context,

    private val medicineList: ArrayList<Medicine>,

    private val onItemClick:
        (Medicine) -> Unit

) : RecyclerView.Adapter<MedicineAdapter.ViewHolder>() {

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val medicineNameTv:
                TextView =
            itemView.findViewById(R.id.medicineNameTv)

        val shopNameTv:
                TextView =
            itemView.findViewById(R.id.shopNameTv)

        val stockTv:
                TextView =
            itemView.findViewById(R.id.stockTv)

        val cardView:
                CardView =
            itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(context)
            .inflate(
                R.layout.item_medicine,
                parent,
                false
            )

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return medicineList.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val medicine =
            medicineList[position]

        holder.medicineNameTv.text =
            medicine.name

        holder.shopNameTv.text =
            medicine.shopName

        holder.stockTv.text =
            "Stock : ${medicine.stock}"

        holder.cardView.setOnClickListener {

            onItemClick(medicine)
        }
    }
}