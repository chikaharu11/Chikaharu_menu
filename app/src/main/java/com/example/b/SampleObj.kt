package com.example.b

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Book: RealmObject() {

    @PrimaryKey
    open var id: Long = 0
    @Required
    open var name : String = ""
}