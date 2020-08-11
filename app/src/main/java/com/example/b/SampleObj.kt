package com.example.b

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Book: RealmObject() {

    @PrimaryKey
    open var id: Long = 0

    open var name : String = ""
}