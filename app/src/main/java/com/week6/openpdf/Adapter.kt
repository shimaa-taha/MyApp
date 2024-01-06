//package com.week6.openpdf
//
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class Adapter(private val mlist : List<class_data>): RecyclerView.Adapter<Adapter.ViewHolder>() {
//    class ViewHolder(Itemview: View) : RecyclerView.ViewHolder(Itemview) {
//
//        val image: ImageView = Itemview.findViewById(R.id.book1)
//        val Name: TextView = Itemview.findViewById(R.id.book1_text)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//
//        return ViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
//        )
//
//    }
//
//    override fun getItemCount(): Int {
//        return mlist.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.image.setImageResource(mlist[position].Image)
//
//        holder.Name.text = mlist[position].name
//        holder.itemView.setOnClickListener()
//        {
//            val intent = Intent(holder.itemView.context, second_activity::class.java)
//            intent.putExtra("name", mlist[position].name)
//            intent.putExtra("image", mlist[position].Image)
//            intent.putExtra("description", mlist[position].Description)
//            intent.putExtra("pdf", mlist[position].pdf)
//            holder.itemView.context.startActivities(arrayOf(intent))
//        }
//    }
//}
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

import com.week6.openpdf.R
import com.week6.openpdf.SecondActivity
import com.week6.openpdf.class_data

class Adapter(private val mlist: List<class_data>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.book1)
        val name: TextView = itemView.findViewById(R.id.book1_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

// Inside Adapter
override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val currentItem = mlist[position]
holder.image.setImageResource(currentItem.Image)
        holder.name.text = currentItem.name
    // ... (other bindings)

//    holder.itemView.setOnClickListener {
//        val intent = Intent(holder.itemView.context, second_activity::class.java)
//        intent.putExtra("name", currentItem.name)
//        intent.putExtra("image", currentItem.Image)
//
//        intent.putExtra("description", currentItem.Description)
//     val pdf=   intent.putExtra("pdfIdentifier", currentItem.pdfPath)
//        holder.itemView.context.startActivity(intent)
//        Log.d("PDF_DEBUG_ADAPTER", "PDF Identifier: $pdf")
//    }
    holder.itemView.setOnClickListener {
      //  val bundle= Bundle()
//        val f2: Fragment =DetailsFragment()
//        val fragmentTransaction: FragmentTransaction =(holder.itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fl_frame,f2).commit()
//        bundle.putString("pdfIdentifier", currentItem.pdfPath)
//        bundle.putString("name", currentItem.name)
//        bundle.putInt("image", currentItem.Image)
//        bundle.putString("description", currentItem.Description)

        val intent = Intent(it.context, SecondActivity::class.java)
        intent.putExtra("pdfIdentifier", currentItem.pdfPath)
        intent.putExtra("name", currentItem.name)
        intent.putExtra("image", currentItem.Image)
        intent.putExtra("description", currentItem.Description)
        it.context.startActivity(intent)
        //f2.arguments=bundle
    }


}

}