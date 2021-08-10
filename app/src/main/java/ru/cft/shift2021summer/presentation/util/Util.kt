package ru.cft.shift2021summer

fun mapToStringConcat(listMap: List<Map<String, String>>): String =
    listMap.joinToString(separator = ", ") { it["name"].toString() }

fun listToStringConcat(list: List<String>): String =
    list.joinToString(separator = ", ")