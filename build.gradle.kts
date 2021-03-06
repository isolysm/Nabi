import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application

    kotlin("jvm")
    kotlin("plugin.serialization")

    id("com.github.johnrengelman.shadow")
}

group = "endeavor.nabi"
version = "0.0.1"

repositories {
    mavenCentral()

    maven {
        name = "Kotlin Discord"
        url = uri("https://maven.kotlindiscord.com/repository/maven-public/")
    }
}

dependencies {

    implementation(libs.kord.extensions)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kord.phishing)

    // Logging dependencies
    implementation(libs.groovy)
    implementation(libs.jansi)
    implementation(libs.logback)
    implementation(libs.logging)

    // Tags
    implementation(libs.kotlinx.serialization)
    implementation(libs.kaml)

    // TOML reader
    implementation("com.github.jezza:toml:1.2")

    // Github API
    implementation("org.kohsuke:github-api:1.301")

    // Exposed
    implementation("org.jetbrains.exposed:exposed-core:0.36.2")
    implementation("org.jetbrains.exposed:exposed-dao:0.36.2")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.36.2")

    // Hikari
    implementation("com.zaxxer:HikariCP:5.0.0")

    // SQLite
    implementation("org.xerial:sqlite-jdbc:3.36.0.3")
}

application {
    // This is deprecated, but the Shadow plugin requires it
    mainClassName = "endeavor.nabi.NabiKt"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"

    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "endeavor.nabi.nabibot.NabiBotKt"
        )
    }
}

// This is to fix an issue with pushing that I cannot seem to fix.
tasks.create<Delete>("detekt") {

}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
