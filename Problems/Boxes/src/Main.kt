import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val (a1, b1, c1) = List(3) { scanner.nextInt() }.sorted()
    val (a2, b2, c2) = List(3) { scanner.nextInt() }.sorted()

    if (a1 == a2 && b1 == b2 && c1 == c2)
        println("Box 1 = Box 2")
    else if (a1 <= a2 && b1 <= b2 && c1 <= c2)
        println("Box 1 < Box 2")
    else if (a1 >= a2 && b1 >= b2 && c1 >= c2)
        println("Box 1 > Box 2")
    else
        println("Incomparable")
}