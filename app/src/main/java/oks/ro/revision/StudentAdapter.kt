package oks.ro.revision

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(var students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.update(student)

        holder.layout.setOnClickListener {
            val intent = Intent(holder.itemView.context, SettingActivity::class.java)
            intent.putExtra("NAME", student.fullName)
            holder.itemView.context.startActivity(intent)
        }
        holder.phone.setOnClickListener {
            val number = student.phone
            val callNuber = Uri.parse("tel:$number")
            val intent = Intent(Intent.ACTION_DIAL, callNuber)
            holder.itemView.context.startActivity(intent)
        }
    }

    inner class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.item_row_name_txt)
        var email: TextView = itemView.findViewById(R.id.item_row_email_txt)
        var phone: ImageView = itemView.findViewById(R.id.item_row_call_imv)
        var layout: LinearLayout = itemView.findViewById(R.id.item_row_vert_llyt)

        fun update(student: Student){
            name.text = student.fullName
            email.text = student.email
        }
    }
}