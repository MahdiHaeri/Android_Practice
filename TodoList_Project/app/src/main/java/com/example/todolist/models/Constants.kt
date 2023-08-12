package com.example.todolist.models

const val DATABASE_VERSION: Int = 1
const val DATABASE_NAME: String = "chore.db"
const val TABLE_NAME: String = "chores"

// Chores table columns names
const val KEY_ID: String = "chore_id"
const val KEY_CHORE_NAME: String = "chore_name"
const val KEY_CHORE_ASSIGNED_BY: String = "chore_assigned_by"
const val KEY_CHORE_ASSIGNED_TO: String = "chore_assigned_to"
const val KEY_CHORE_ASSIGNED_TIME: String = "chore_assigned_time"
