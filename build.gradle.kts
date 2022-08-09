repositories {
  mavenCentral()
  maven("https://repo.spring.io/milestone")
  maven("https://repo.spring.io/snapshot")
  maven("https://jitpack.io")
}
plugins {
  kotlin("jvm") version "1.7.10"
  kotlin("plugin.spring") version "1.7.10"
  kotlin("plugin.serialization") version "1.7.10"
  id("org.springframework.boot") version "3.0.0-SNAPSHOT"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
}
dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("com.github.demidko:telegram-storage:2022.05.30")
  implementation("org.apache.commons:commons-csv:1.9.0")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("com.google.truth:truth:1.1.3")
  testImplementation("io.mockk:mockk:1.12.5")
}
tasks.compileKotlin {
  kotlinOptions.jvmTarget = "18"
  kotlinOptions.freeCompilerArgs += listOf("-opt-in=kotlin.time.ExperimentalTime", "-Xjsr305=strict")
}
tasks.compileTestKotlin {
  kotlinOptions.jvmTarget = "18"
  kotlinOptions.freeCompilerArgs += listOf("-opt-in=kotlin.time.ExperimentalTime", "-Xjsr305=strict")
}
tasks.test {
  useJUnitPlatform()
}
tasks.bootJar {
  archiveVersion.set("boot")
}