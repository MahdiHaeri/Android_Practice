package com.example.todolist.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.controllers.adapters.ChoreListAdapter
import com.example.todolist.data_access.ChoreDAO
import com.example.todolist.models.Chore
import com.example.todolist.databinding.ActivityChoreListBinding

class ChoreListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChoreListBinding
    private var adapter: ChoreListAdapter? = null
    private var choreList: ArrayList<Chore>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var dbHandler: ChoreDAO? = null

    private var alertDialogBuilder: AlertDialog.Builder? = null
    private var alertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoreListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHandler = ChoreDAO(this)
        choreList = ArrayList<Chore>()

        layoutManager = LinearLayoutManager(this)
        binding.choreListRecyclerView.layoutManager = layoutManager

        updateAdapter()
    }

    fun updateAdapter() {
        choreList!!.clear()
        choreList = dbHandler!!.readChores()
        choreList!!.reverse()
        adapter = ChoreListAdapter(choreList!!, this)
        binding.choreListRecyclerView.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if (item.itemId == R.id.add_menu_button) {
//            startActivity(Intent(this, MainActivity::class.java))
            createPopupDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    fun createPopupDialog() {
        var view = LayoutInflater.from(this).inflate(R.layout.popup, null)
        var choreName = view.findViewById<EditText>(R.id.enterChoreTp)
        var assignedBy = view.findViewById<EditText>(R.id.assignByTp)
        var assignedTo = view.findViewById<EditText>(R.id.assignToTp)
        var saveButton = view.findViewById<Button>(R.id.saveChoreButton)

        alertDialogBuilder = AlertDialog.Builder(this).setView(view)
        alertDialog = alertDialogBuilder!!.create()
        alertDialog?.show()

        saveButton.setOnClickListener {
            if (!choreName.text.isEmpty() && !assignedBy.text.isEmpty() && !assignedTo.text.isEmpty()) {
                var chore = Chore()
                chore.setChoreName(choreName.text.toString())
                chore.setAssignedBy(assignedBy.text.toString())
                chore.setAssignedTo(assignedTo.text.toString())
                dbHandler!!.createChore(chore)
                alertDialog!!.dismiss()
//                startActivity(intent)
//                finish()
                updateAdapter()
            }
        }
    }
}