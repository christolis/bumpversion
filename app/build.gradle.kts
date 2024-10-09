import java.io.ByteArrayOutputStream

plugins {
    kotlin("jvm") version "1.8.0"
}

tasks.register("generateVersionFile") {
    val versionFile = file("src/main/kotlin/org/example/Version.kt")

    doLast {
        val outputStream = ByteArrayOutputStream()

        exec {
            commandLine("git", "describe", "--tags", "--long", "--always", "--abbrev=9")
            standardOutput = outputStream
        }

        var version = outputStream.toString().trim()

        // If there is no distance between the tag and the current
        // commit, don't include it.
        version = version.replace("-0-", "-")

        versionFile.parentFile.mkdirs()

        versionFile.writeText("""
            package org.example

            object Version {
                const val VERSION = "$version"
            }
        """.trimIndent())
    }
}

tasks.build {
    dependsOn("generateVersionFile")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}
