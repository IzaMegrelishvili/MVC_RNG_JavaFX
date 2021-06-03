plugins {
    // Optional but useful for IntelliJ and Eclipse
    idea
    eclipse

    // 'java' is optional as it is a dependency of 'application'
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    run { // JavaFX dependencies
        val group = "org.openjfx"
        val version = "15.0.1"
        val fxModules = arrayListOf("javafx-base", "javafx-graphics", "javafx-controls", "javafx-fxml")

        val osName = System.getProperty("os.name")
        val platform = when {
            osName.startsWith("Mac", ignoreCase = true) -> "mac"
            osName.startsWith("Windows", ignoreCase = true) -> "win"
            osName.startsWith("Linux", ignoreCase = true) -> "linux"
            else -> throw GradleException("Unknown platform $osName")
        }

        fxModules.forEach {
            implementation("$group:$it:$version:$platform")
        }
    }
}

group = "de.uni-passau.se.mvc_rng"
version = "0.9-BETA"

application {
    mainModule.set("de.uni_passau.se.mvc_rng")
    mainClass.set("de.uni_passau.se.mvc_rng.GUI")
}

java {
    modularity.inferModulePath.set(true)

    toolchain {
        version = org.gradle.api.JavaVersion.VERSION_15
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

idea.module {
    isDownloadJavadoc = true
    isDownloadSources = true
}

eclipse.classpath {
    isDownloadJavadoc = true
    isDownloadSources = true
}
