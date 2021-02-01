fun main() = List(3) { readLine()!!.toBigInteger() } // read 3 BigIntegers into list<BigInteger>
    .distinct() // change list<BigIntegers> into another with distinct numbers only
    .size // change list of distinct numbers to count of distinct numbers
    .let { if (it == 3) 0 else 4 - it } // change count of distinct numbers into result
    .let(::println) // print result