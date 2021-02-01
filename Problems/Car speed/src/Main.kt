fun result(speed: Int, limit: Int = 60) =
    if (speed <= limit) "Within the limit" else "Exceeds the limit by ${speed - limit} kilometers per hour"

fun main() {
    val (speed, limit) = List(2) { readLine()!!.toIntOrNull() }
    println(if (limit == null) result(speed!!) else result(speed!!, limit))
}