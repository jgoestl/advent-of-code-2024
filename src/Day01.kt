import kotlin.math.abs

fun main() {
    fun part1(input: Array<ArrayList<String>>): Int {
        val listDistances = ArrayList<Int>()

        val listA = input[0]
        val listB = input[1]

        listA.sort()
        listB.sort()

        for (i in listA.indices) {
            val distance = listA[i].toInt() - listB[i].toInt()
            listDistances.add(abs(distance))
        }

        return listDistances.sum()
    }

    fun part2(input: Array<ArrayList<String>>): Int {
        val listSimilarityScore = ArrayList<Int>()

        val listA = input[0]
        val listB = input[1]

        listA.stream().forEach {
            val a = it

            var count = 0
            for (i in listB.indices) {
                if (a == listB[i]) {
                    count++
                }
            }
            listSimilarityScore.add(a.toInt()  * count)
        }

        return listSimilarityScore.sum()
    }

    fun splitInput(input: List<String>): Array<ArrayList<String>> {
        val listA = ArrayList<String>()
        val listB = ArrayList<String>()

        input.stream().map { it.split("\\s+".toRegex()) }.forEach {
            listA.add(it[0])
            listB.add(it[1])
        }

        return arrayOf(listA, listB)
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(splitInput(testInput)) == 11)
    check(part2(splitInput(testInput)) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(splitInput(input)).println()
    part2(splitInput(input)).println()
}
