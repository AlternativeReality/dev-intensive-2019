package ru.skillbranch.devintensive.extensions

import android.util.TimeUtils
import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
//    val dateFormat =
    return SimpleDateFormat(pattern, Locale("ru")).format(this)
    //return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits {
    SECOND {
        override fun plural(count: Int): String {
            var n = count
            n %= 100
            if (n in 5..20) {
                return "$count секунд"
            }
            n %= 10
            if (n == 1) {
                return "$count секунду"
            }
            if (n in 2..4) {
                return "$count секунды"
            }
            return "$count секунд"

        }
    },
    MINUTE {
        override fun plural(count: Int): String {
            var n = count
            n %= 100
            if (n in 5..20) {
                return "$count минут"
            }
            n %= 10
            if (n == 1) {
                return "$count минуту"
            }
            if (n in 2..4) {
                return "$count минуты"
            }
            return "$count минут"
        }

    },
    HOUR {
        override fun plural(count: Int): String {
            var n = count
            n %= 100
            if (n in 5..20) {
                return "$count часов"
            }
            n %= 10
            if (n == 1) {
                return "$count час"
            }
            if (n in 2..4) {
                return "$count часа"
            }
            return "$count часов"
        }

    },

    DAY {
        override fun plural(count: Int): String {
            var n = count
            n %= 100
            if (n in 5..20) {
                return "$count дней"
            }
            n %= 10
            if (n == 1) {
                return "$count день"
            }
            if (n in 2..4) {
                return "$count дня"
            }
            return "$count дней"
        }

    };

    abstract fun plural(count: Int): String
}

fun Date.humanizeDiff(): String { //date: Date = Date()
    var date = this
    val currentTime = Date().time
//    (MINUTE).easyPrint()
//    date.time.easyPrint()
//    currentTime.easyPrint()
    val differenceTime = (currentTime - date.time).absoluteValue
//    var idea:Float = differenceTime / SECOND.toFloat()
//    idea.easyPrint()
    (differenceTime / SECOND.toFloat() / 3600).roundToInt().easyPrint()
    return when (differenceTime) {
        in 0..1 * SECOND -> "только что"
        in 1 * SECOND..45 * SECOND -> "несколько секунд назад"
        in 46 * SECOND..75 * SECOND -> "минуту назад"
        in 76 * SECOND..45 * MINUTE -> "${TimeUnits.MINUTE.plural((differenceTime / SECOND.toFloat() / 60).roundToInt())} назад"//2700* SECOND
        in 2701 * SECOND..4500 * SECOND -> "час назад"
        in 4501 * SECOND..79200 * SECOND -> "${TimeUnits.HOUR.plural((differenceTime / SECOND.toFloat() / 3600).roundToInt())} назад"
        in 79200 * SECOND..93600 * SECOND -> "день назад"
        in 93601 * SECOND..31104000 * SECOND -> "${TimeUnits.DAY.plural((differenceTime / SECOND.toFloat() / 3600 / 24).roundToInt())} назад"
        else -> "более года назад"

    }

}