package com.example.todolist.controllers.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data_access.ChoreDAO
import com.example.todolist.models.Chore

class ChoreListAdapter(private val list: ArrayList<Chore>, private val context: Context) : RecyclerView.Adapter<ChoreListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoreListAdapter.ViewHolder {
        // create our view from our xml file
        val view = LayoutInflater.from(context).inflate(R.layout.chore_item, parent, false)
        return ViewHolder(view, context)
    }


    override fun onBindViewHolder(holder: ChoreListAdapter.ViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {
        val choreName = itemView.findViewById<TextView>(R.id.choreNameTextView)
        val assignedBy = itemView.findViewById<TextView>(R.id.assignByTextView)
        val assignedTo = itemView.findViewById<TextView>(R.id.assignToTextView)
        val assignedDate = itemView.findViewById<TextView>(R.id.dateTextView)
        val deleteButton = itemView.findViewById<ImageButton>(R.id.deleteChoreButton)
        val editButton = itemView.findViewById<ImageButton>(R.id.editChoreButton)

        fun bindView(chore: Chore) {
            choreName.text = chore.getChoreName()
            assignedBy.text = chore.getAssignedBy()
            assignedTo.text = chore.getAssignedTo()
            assignedDate.text = chore.showHumanDate(chore.getTimeAssigned())

            deleteButton.setOnClickListener {
                deleteChore(chore)
                list.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }

            editButton.setOnClickListener {
                updateChore(chore)
            }
        }

        fun deleteChore(chore: Chore) {
            var db = ChoreDAO(context)
            db.deleteChore(chore.getId())
        }

        fun updateChore(chore: Chore) {
            var dbHandler = ChoreDAO(context)
            var alertDialogBuilder: AlertDialog.Builder? = null
            var alertDialog: AlertDialog? = null

            var view = LayoutInflater.from(context).inflate(R.layout.popup, null)
            var choreName = view.findViewById<EditText>(R.id.enterChoreTp)
            var assignedBy = view.findViewById<EditText>(R.id.assignByTp)
            var assignedTo = view.findViewById<EditText>(R.id.assignToTp)
            var saveButton = view.findViewById<Button>(R.id.saveChoreButton)

            choreName.setText(chore.getChoreName())
            assignedBy.setText(chore.getAssignedBy())
            assignedTo.setText(chore.getAssignedTo())

            alertDialogBuilder = AlertDialog.Builder(context).setView(view)
            alertDialog = alertDialogBuilder!!.create()
            alertDialog.show()

            saveButton.setOnClickListener {
                if (choreName.text.isNotEmpty() && assignedBy.text.isNotEmpty() && assignedTo.text.isNotEmpty()) {
                    chore.setChoreName(choreName.text.toString())
                    chore.setAssignedBy(assignedBy.text.toString())
                    chore.setAssignedTo(assignedTo.text.toString())
                    dbHandler.updateChore(chore)
                    notifyItemChanged(adapterPosition, chore)
                    alertDialog.dismiss()
                }
            }
        }
    }
}