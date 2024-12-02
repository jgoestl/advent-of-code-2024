import kotlin.math.abs

fun main() {
    fun splitReport(report: String): List<String> {
        return report.split("\\s+".toRegex())
    }

    fun part1(reports: List<String>): Int {
        var safeCount = 0

        reports.forEach() {
            if (checkSafeReport(splitReport((it)), true)) {
                safeCount++
            }
        }

        return safeCount
    }

    fun part2(reports: List<String>): Int {
        var safeCount = 0

        reports.forEach() {
            if (checkSafeReport(splitReport((it)))) {
                safeCount++
            }
        }
        return safeCount
    }


    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun checkSafeReport(report: List<String>, isUnsafeLevelRemoved: Boolean = false): Boolean {
    var isSafe = false
    var isDecreasing: Boolean? = null

    for (i in report.indices) {
        if (i < report.size - 1) {
            val x = report[i].toInt() - report[i + 1].toInt()
            if (x > 0) {
                if (isDecreasing == null) {
                    isDecreasing = true
                } else {
                    if (isDecreasing == false) {
                        if (!isUnsafeLevelRemoved) {
                            return removeUnsafeLevel(report, i)
                        } else {
                            isSafe = false
                            break
                        }
                    }
                }
            } else if (x < 0) {
                if (isDecreasing == null) {
                    isDecreasing = false
                } else {
                    if (isDecreasing == true) {
                        if (!isUnsafeLevelRemoved) {
                            return removeUnsafeLevel(report, i)
                        } else {
                            isSafe = false
                            break
                        }
                    }
                }
            }
            if (abs(x) in 1..3) {
                isSafe = true
            } else {
                if (!isUnsafeLevelRemoved) {
                    return removeUnsafeLevel(report, i)
                } else {
                    isSafe = false
                    break
                }
            }
        }
    }

    return isSafe
}

private fun removeUnsafeLevel(report: List<String>, i: Int): Boolean {
    var newReport = report.toMutableList()
    newReport.removeAt(i)
    var result = checkSafeReport(newReport, true)
    if (!result && i < report.size - 1) {
        newReport = report.toMutableList()
        newReport.removeAt(i + 1)
        result = checkSafeReport(newReport, true)
    }
    if (!result && i > 0) {
        newReport = report.toMutableList()
        newReport.removeAt(i - 1)
        result = checkSafeReport(newReport, true)
    }
    return result
}
