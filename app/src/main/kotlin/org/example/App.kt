package org.example

class App {
    val greeting: String
        get() {
            return "Hi " + Version.VERSION
        }
}

fun main() {
    println(App().greeting)
}
