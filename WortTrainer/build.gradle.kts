plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
dependencies {

    // https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path
    implementation("com.jayway.jsonpath:json-path:2.8.0")

    //GSON ist eine Bibliothek zum Schreiben und Lesen
    implementation("com.google.code.gson:gson:2.8.8")



}

tasks.test {
    useJUnitPlatform()
}