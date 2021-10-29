plugins {
    application
    java
}

group = "net.snezhniy"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("net.snezhniy.App")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "net.snezhniy.App"
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

dependencies { }