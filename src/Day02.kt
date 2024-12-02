import kotlin.math.abs

fun main() {
    fun splitReport(report: String): List<String> {
        return report.split("\\s+".toRegex())
    }

    fun part1(reports: List<String>): Int {
        var safeCount = 0

        reports.forEach() {
            var isSafe = false;
            var isDecreasing: Boolean? = null

            val report = splitReport(it)
            for (i in report.indices) {
                if (i < report.size - 1) {
                    val x = report[i].toInt() - report[i + 1].toInt()
                    if (x > 0) {
                        if (isDecreasing == null) {
                            isDecreasing = true
                        } else {
                            if (!isDecreasing) {
                                isSafe = false
                                break
                            }
                        }
                    } else {
                        if (isDecreasing == null) {
                            isDecreasing = false
                        } else {
                            if (isDecreasing) {
                                isSafe = false
                                break
                            }
                        }
                    }
                    if (abs(x) in 1..3) {
                        isSafe = true
                    } else {
                        isSafe = false
                        break
                    }
                }
            }

            if (isSafe) {
                safeCount++
            }
        }

        return safeCount
    }

    fun part2(input: Array<ArrayList<String>>): Int {
        return 0
    }


    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    //check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    //part2(input).println()
}
