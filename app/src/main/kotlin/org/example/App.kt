package org.example

class App {
    val greeting: String
        get() {
            return "Hi wazei! The version is: " + Version.VERSION
        }
}

fun main() {
    println(App().greeting)
}
