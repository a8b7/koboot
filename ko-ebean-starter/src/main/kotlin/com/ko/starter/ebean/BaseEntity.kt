package com.ko.starter.ebean

import io.ebean.Model
import io.ebean.annotation.*
import java.io.Serializable
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity : Model(), Serializable{
    @Id
    @GeneratedValue(generator = "SnowFlake")
    var id:Long = 0

    @WhenCreated
    lateinit var createdAt: Date

    @WhenModified
    lateinit var modifiedAt: Date

    @WhoCreated
    var createdBy: Long? = null

    @WhoModified
    var modifiedBy: Long? = null

    @SoftDelete
    var deleted: Boolean = false

    fun idIsZero():Boolean{
        return id == 0L
    }
}
