plugins {
    kotlin("jvm") version "1.5.31"
    application
}

group = "net.snezhniy"
version = "1.1-SNAPSHOT"

application {
    mainClass.set("net.snezhniy.AppKt")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "net.snezhniy.AppKt"
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt")
}