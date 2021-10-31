plugins {
    kotlin("jvm") version "1.5.31"
    application
}

group = "net.snezhniy"
version = "1.2-SNAPSHOT"

application {
    mainClass.set("net.snezhniy.AppKt")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }

    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
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
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.31")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
}