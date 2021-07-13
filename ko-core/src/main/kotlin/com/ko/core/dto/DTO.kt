package com.ko.core.dto
import java.io.Serializable

interface VO

interface Command

interface Query

abstract class PageQuery : Query{
    var pageIndex: Int = 0
    var pageSize: Int = 15
    var orderBy: String = ""
    var orderDirection: String = "DESC"
}

interface Vo

data class R (val success: Boolean = true): Serializable{

    var data: Any? = null
    var total: Int? = null
    var error: Error? = null

    constructor(data: Any?): this(){
        this.data = data
    }

    constructor(data: Any?, total: Int?): this(){
        this.data = data
        this.total = total
    }
    constructor(error: Error?): this(false){
        this.error = error
    }

    companion object{
        fun success(): R = R()
        fun success(data: Any?): R = R(data)
        fun success(data: Any?, total: Int?): R = R(data, total)
        fun error(msg: String?): R = R(msg)

    }


}

data class Error(val msg :String?, val code:Int)