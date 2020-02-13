package ru.skillbranch.devintensive.utils

import org.jetbrains.annotations.NotNull
import ru.skillbranch.devintensive.extensions.easyPrint
import android.database.sqlite.*
object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {//Pair<String?, String?>
        var parts: MutableList<String>? = fullName?.split(" ")?.toMutableList()
        //parts?.remove(" ")
        // parts?.easyPrint()
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        if (firstName.isNullOrBlank()) {
            firstName = null

        }
        if (lastName.isNullOrBlank()) lastName = null
        return (firstName to lastName)
    }


    fun toInitials(firstName: String?, lastName: String?): String? {
        if (firstName.isNullOrBlank() && lastName.isNullOrBlank()) {
            return null
        }
        var A = firstName?.getOrNull(0)?.toUpperCase() ?: ""
        var B = lastName?.getOrNull(0)?.toUpperCase() ?: ""
        return "$A$B"

    }

    fun transliteration(name: String, divider: String = " "): String {
        val dictionary = mapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            // "Ж" to "Zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh\'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya",
            " " to "$divider"
        )

        var result = name

        dictionary.forEach { (l, r) ->

            result = result.replace(l, r)
            result = result.replace(l.capitalize(), r.capitalize())
        }

        return result
    }

}