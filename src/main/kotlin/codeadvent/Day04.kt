package codeadvent

import java.io.File

class Passport(private val map: Map<String, String>) {
    private val requiredKeys = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    fun hasAllRequiredFields(): Boolean {
        return map.keys.containsAll(requiredKeys)
    }

    fun hasValidValues(): Boolean {
        return map.all { (key, value) ->
            when (key) {
                "byr" -> value.length == 4 && value.toIntOrNull() in 1920..2002
                "iyr" -> value.length == 4 && value.toIntOrNull() in 2010..2020
                "eyr" -> value.length == 4 && value.toIntOrNull() in 2020..2030
                "pid" -> value.length == 9 && value.all(Char::isDigit)
                "ecl" -> value in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
                "hgt" -> when (value.takeLast(2)) {
                    "cm" -> value.removeSuffix("cm").toIntOrNull() in 150..193
                    "in" -> value.removeSuffix("in").toIntOrNull() in 59..76
                    else -> false
                }
                "hcl" -> value matches """#[0-9a-f]{6}""".toRegex()
                else -> true
            }
        }
    }

    companion object {
        fun fromString(s: String): Passport {
            val fieldAndValues = s.split(" ", "\n")
            val map = fieldAndValues.associate {
                val (key, value) = it.split(":")
                key to value
            }
            return Passport(map)
        }
    }
}

fun main() {
 val passports = File("src/day04/day04data")
     .readText()
     .trim()
     .split("\n\n", "\r\n\r\n")
     .map { Passport.fromString(it) }

    println("Part One: Valid passports are: ${passports.count { it.hasAllRequiredFields() }}")
    println("Part Two: Valid passports are: ${passports.count { it.hasAllRequiredFields() && it.hasValidValues() }}")

}