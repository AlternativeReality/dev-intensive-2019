package ru.skillbranch.devintensive.extensions

import java.lang.Exception


fun String.stripHtml():String{
   // var result = this.replace("[/<(.|\\n)*?>]".toRegex(), "")
    var result = this.replace("<.*?>".toRegex(), "").replace("[\\s]{2,}".toRegex(), " ")
    return result

}

fun String.truncate(last:Int=16):String{

    try {
        var result= this.trim().substring(0, last)
        if (result== this.trim()){
            return this
        } else
        {
            result= result.trim()+"..."
        }
        return result
    } catch (e: Exception){
        return this
    }

}
fun Any.easyPrint() = println(this)