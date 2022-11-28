package com.example.salttechnicaltest.data.endpoint

object ReqresUrl {
    const val baseUrl = "https://reqres.in/api/"

    object Auth {
        const val register = "${baseUrl}login"
        const val login = "${baseUrl}login"
    }

    object Users {
        const val userList = "${baseUrl}users"
        const val alterUser = "${baseUrl}users/{id}"
    }
}