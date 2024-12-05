fun main() {
    fun part1(lines: List<String>): Int {
        val rows = lines.size
        val cols = lines[0].length
        return lines.mapIndexed { r, rv ->
            rv.mapIndexed { c, _ ->
                listOf(
                    r + 3 < rows && c + 3 < cols && (0..3).map { lines[r + it][c + it] }
                        .joinToString("") in "XMAS SAMX",
                    r + 3 < rows && (0..3).map { lines[r + it][c] }.joinToString("") in "XMAS SAMX",
                    c + 3 < cols && lines[r].substring(c, c + 4) in "XMAS SAMX",
                    r - 3 >= 0 && c + 3 < cols && (0..3).map { lines[r - it][c + it] }.joinToString("") in "XMAS SAMX"
                ).count { it }
            }.sum()
        }.sum()
    }

    fun part2(lines: List<String>): Int {
        val rows = lines.size
        val cols = lines[0].length
        return lines.mapIndexed { r, rv ->
            rv.filterIndexed { c, _ ->
                r + 2 < rows && c + 2 < cols && (0..2).map { lines[r + it][c + it] }.joinToString("") in "MAS SAM" &&
                        (0..2).map { lines[r + 2 - it][c + it] }.joinToString("") in "MAS SAM"
            }.length
        }.sum()
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInputLines("Day04_test")

    check(part1(testInput) == 18)
    check(part2(testInput) == 9)

    // Read the input from the `src/Day01.txt` file.
    val input = readInputLines("Day04")
    part1(input).println()
    part2(input).println()
}
