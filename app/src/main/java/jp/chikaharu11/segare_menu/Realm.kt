package jp.chikaharu11.segare_menu

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Book: RealmObject() {

    @PrimaryKey
    open var id: Long = 0
    @Required
    open var name : String = ""
}

open class Book2: RealmObject() {

    @PrimaryKey
    open var id: Long = 0
    @Required
    open var name : String = ""
}

open class Book3: RealmObject() {

    @PrimaryKey
    open var id: Long = 0
    @Required
    open var name : String = ""
}

open class Book4: RealmObject() {

    @PrimaryKey
    open var id: Long = 0
    @Required
    open var name : String = ""
}

open class Book5: RealmObject() {

    @PrimaryKey
    open var id: Long = 0
    @Required
    open var name : String = ""
}

open class Book6: RealmObject() {

    @PrimaryKey
    open var id: Long = 0
    @Required
    open var name : String = ""
    open var boolean : Boolean = true
}