import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
    id("org.jmailen.kotlinter") version "3.8.0"
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "in.technowolf"
version = "1.0.4"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven {
        name = "nabi"
        url = uri("https://maven.kotlindiscord.com/repository/maven-public/")
    }
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.1-RC1")
    implementation("com.kotlindiscord.kord.extensions:time4j:1.5.1-RC1")
    implementation("io.ktor:ktor-client-core:1.6.7")
    implementation("org.slf4j:slf4j-simple:1.7.32")
    implementation("net.dean.jraw:JRAW:1.1.0")
    implementation("org.jetbrains.exposed:exposed-core:0.36.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.36.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.36.1")
    implementation("org.xerial:sqlite-jdbc:3.36.0.2")
    implementation ("io.getunleash:unleash-client-java:5.0.3")
    implementation("dev.kord.x:emoji:0.5.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
}

tasks.check {
    dependsOn("installKotlinterPrePushHook")
}

kotlinter {
    ignoreFailures = false
    indentSize = 4
    reporters = arrayOf("checkstyle", "plain")
    experimentalRules = false
    disabledRules = arrayOf("no-wildcard-imports", "import-ordering", "indent")
}
