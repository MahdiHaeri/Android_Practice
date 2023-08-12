package com.example.todolist.controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.todolist.R
import com.example.todolist.controllers.adapters.ChoreListAdapter
import com.example.todolist.data_access.ChoreDAO
import com.example.todolist.models.Chore
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var dbHandler: ChoreDAO? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHandler = ChoreDAO(this)
        checkDb()

//        var newChore = Chore()
//        newChore.setChoreName("Public site")
//        newChore.setAssignedBy("Mahdi")
//        newChore.setAssignedTo("Ali")
//
//        dbHandler!!.createChore(newChore)
//
//        // read from database
//        var chores: Chore? = dbHandler?.getAChore(1)
//
//        Log.d("Chore name", chores?.getChoreName().toString())
    }

    fun onSaveBtnClicked(view: View) {
        if (binding.enterChoreTp.text.toString().isEmpty() ||
            binding.assignToTp.text.toString().isEmpty() ||
            binding.assignByTp.text.toString().isEmpty()) {
            Log.d("DB", "Empty")
            Toast.makeText(this, "Please enter a chore", Toast.LENGTH_LONG).show()
            return
        }

        var chore = Chore()
        chore.setChoreName(binding.enterChoreTp.text.toString())
        chore.setAssignedBy(binding.assignToTp.text.toString())
        chore.setAssignedTo(binding.assignByTp.text.toString())
        dbHandler?.createChore(chore)
        Toast.makeText(this, "Chore saved successfully", Toast.LENGTH_LONG).show()
        binding.enterChoreTp.setText("")
        binding.assignToTp.setText("")
        binding.assignByTp.setText("")
        startActivity(Intent(this, ChoreListActivity::class.java))
    }

    fun checkDb() {
        if (dbHandler?.getChoresCount()!! > 0) {
            startActivity(Intent(this, ChoreListActivity::class.java))
        }
    }
}