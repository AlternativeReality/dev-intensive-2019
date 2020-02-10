package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import ru.skillbranch.devintensive.utils.Utils.parseFullName
import java.util.*


data class User(
    val id: String,
    var firstName: String?,
    val lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false
) {


    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        println(
            "It's Alive!!! \n" +
                    "${if (lastName === "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName"}\n"
        )
    }

    companion object Factory {
        private var lastId = -1
        fun makeUser(fullName: String?): User {
            lastId++
//             if (fullName.isNullOrBlank()) {
//                return User(id = "$lastId")
//            }


                var (firstName, lastName)= Utils.parseFullName(fullName)
                return User(id = "$lastId", firstName = firstName, lastName = lastName)
        //    }

        }


    }


}
