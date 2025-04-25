plugins {
    kotlin("jvm") version "2.1.20"
}

group = "me.npanuhin.cu.kyrgyz_keyboard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        implementation(files("lib/lttoolbox.jar"))
    }

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}