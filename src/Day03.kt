fun main() {
    fun calculate(input: String, regex: Regex = ".*".toRegex()): Int {
        var resultSum = 0
        val matchResultsDo = regex.findAll(input)
        matchResultsDo.forEach { lineDo ->
            val matchResultsMul = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex().findAll(lineDo.value)
            matchResultsMul.forEach {
                val matchResultsNumbers = "\\d+".toRegex().findAll(it.value)
                if (matchResultsNumbers.count() > 0) {
                    resultSum += matchResultsNumbers.elementAt(0).value.toInt() * matchResultsNumbers.elementAt(1).value.toInt()
                }
            }
        }

        return resultSum
    }

    fun part1(input: String): Int {
        return calculate(input)
    }

    fun part2(input: String): Int {
        return calculate(input, "(^.*?don't\\(\\)|do\\(\\).*?don't\\(\\)|do\\(\\).*?\$)".toRegex())
    }


    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    val testInput2 = readInput("Day03_test_2")
    check(part2(testInput2) == 136)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()

}
