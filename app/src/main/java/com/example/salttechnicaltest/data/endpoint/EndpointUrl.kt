package com.example.salttechnicaltest.data.endpoint

object ReqresUrl {
    const val baseUrl = "https://reqres.in/api/"

    const val login = "${baseUrl}login"

    object Users {
        const val userList = "${baseUrl}users"
        const val alterUser = "${baseUrl}users/{id}"
    }
}