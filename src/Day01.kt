fun main() {
    fun part1(input: List<String>): Int {
        val listA = ArrayList<String>()
        val listB = ArrayList<String>()
        val listDistances = ArrayList<Int>()

        input.stream().map { it.split("\\s+".toRegex()) }.forEach {
            listA.add(it[0])
            listB.add(it[1])
        }

        listA.sort()
        listB.sort()


        for (i in input.indices) {
            val distance = listA[i].toInt() - listB[i].toInt()
            listDistances.add(Math.abs(distance))
        }

        return listDistances.sum()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    //part2(input).println()
}
