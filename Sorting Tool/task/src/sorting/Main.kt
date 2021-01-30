package sorting

import java.io.File
import java.util.*

private fun <E> List<E>.printNatural() {
    val size = this.size
    val string = this.joinToString(" ")
    println("Total numbers: $size\nSorted data: $string")
}

private fun <E, V : List<E>> Map<E, V>.printByCount() {
    println("Total lines: ${this.flatMap { it.value }.size}")
    this
        .map { it.key to it.value.size }
        .sortedBy { it.second }
        .forEach { println("${it.first}: ${it.second} time(s), ${it.second * 100 / size}%") }
}

fun <E, R : Comparable<R>> List<E>.orderBy(lambda: (String) -> R) =
    this.joinToString(" ")
        .split(" ")
        .filter { it.isNotBlank() }
        .map(lambda)
        .sorted()

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val sortingType = Regex("""-sortingType (\w+)""").find(args.joinToString(" "))?.groupValues?.get(1)
    val dataType = Regex("""-dataType (\w+)""").find(args.joinToString(" "))?.groupValues?.get(1)
    val inputFileName = Regex("""-inputFile (\S+)""").find(args.joinToString(" "))?.groupValues?.get(1)
    val outputFileName = Regex("""-outputFile (\S+)""").find(args.joinToString(" "))?.groupValues?.get(1)
    val text = mutableListOf<String>()
    val inputFile: File by lazy { File(inputFileName!!) }
    val outputFile: File by lazy { File(outputFileName!!) }

    if (!outputFileName.isNullOrBlank()) outputFile.writeText("")
    if (!inputFileName.isNullOrBlank())
        try {
            inputFile.forEachLine { text.add(it) }
        } catch (e: Exception) {
            outputFile.writeText(e.message!!)
        }
    else
        while (scanner.hasNext()) text.add(scanner.nextLine()!!)
    when (sortingType) {
        "natural", null -> when (dataType) {
            "long" -> text
                .orderBy { it.toLong() }
                .printNatural()
            "word" -> text
                .orderBy { it }
                .printNatural()
            "line" -> text
                .sorted()
                .printNatural()
        }
        "byCount" -> when (dataType) {
            "long" ->
                text.orderBy { it.toLong() }
                    .groupBy { it }
                    .printByCount()
            "word" ->
                text.orderBy { it }
                    .groupBy { it }
                    .printByCount()
            "line" ->
                text.sorted()
                    .groupBy { it }
                    .printByCount()
        }
    }
}