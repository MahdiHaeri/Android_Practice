package com.example.todolist.models

class Chore() {
    private var id: Int = 0
    private var choreName: String? = null
    private var assignedBy: String? = null
    private var assignedTo: String? = null
    private var timeAssigned: Long = 0

    constructor(id: Int, choreName: String, assignedBy: String, assignedTo: String, timeAssigned: Long) : this() {
        this.id = id
        this.choreName = choreName
        this.assignedBy = assignedBy
        this.assignedTo = assignedTo
        this.timeAssigned = timeAssigned
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getChoreName(): String? {
        return choreName
    }

    fun setChoreName(choreName: String) {
        this.choreName = choreName
    }

    fun getAssignedBy(): String? {
        return assignedBy
    }

    fun setAssignedBy(assignedBy: String) {
        this.assignedBy = assignedBy
    }

    fun getAssignedTo(): String? {
        return assignedTo
    }

    fun setAssignedTo(assignedTo: String) {
        this.assignedTo = assignedTo
    }

    fun getTimeAssigned(): Long {
        return timeAssigned
    }

    fun setTimeAssigned(timeAssigned: Long) {
        this.timeAssigned = timeAssigned
    }

    override fun toString(): String {
        return "Chore(id=$id, choreName=$choreName, assignedBy=$assignedBy, assignedTo=$assignedTo, timeAssigned=$timeAssigned)"
    }

    fun showHumanDate(currentTimeMillis: Long): CharSequence? {
        var simple = java.text.SimpleDateFormat("dd/MMM/yyyy")
        return simple.format(currentTimeMillis)
    }
}