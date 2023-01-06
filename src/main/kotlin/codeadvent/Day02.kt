package codeadvent

import java.io.File

/***
 * Day 2. Password philosophy
 */
data class PasswordWithPolicy(
    val password: String,
    val range: IntRange,
    val letter: Char
) {

    fun validPartOne() = password.count { it == letter } in range

    fun validPartTwo() =  (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)
    /*
    Sample Data:
    1-3 a: abcde
    1-3 b: cdefg
    2-9 c: ccccccccc
     */

    companion object {
        fun parse(line: String): PasswordWithPolicy =
            PasswordWithPolicy(
                password = line.substringAfter(": "),
                letter = line.substringAfter(" ").substringBefore(":").single(),
                range = line.substringBefore(" ")
                    .let {
                        val (start, end) = it.split("-")
                        start.toInt()..end.toInt()
                    }
            )
    }

    // To ensure that input string matching the patteren
    private val regex = Regex("""(\d+)-(\d+) ([a-z]): ([a-z]+)""")
    fun parseUsingRegex(line: String) =
        regex.matchEntire(line)
            ?.destructured
            ?.let { (start, end, letter, password) ->
                PasswordWithPolicy(password, start.toInt()..end.toInt(), letter.single())
            }

}

fun main() {
    val passwords = File("src/day02/day02input.txt")
        .readLines()
        .map { PasswordWithPolicy.parse(it) }

    println("Part one: ${ passwords.count { it.validPartOne() }}")
    println("Part two: ${ passwords.count { it.validPartTwo() }}")
}