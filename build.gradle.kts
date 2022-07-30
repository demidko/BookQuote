repositories {
  mavenCentral()
  maven("https://repo.spring.io/milestone")
  maven("https://repo.spring.io/snapshot")
  maven("https://jitpack.io")
}
plugins {
  id("org.springframework.boot") version "3.0.0-SNAPSHOT"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.7.10"
  kotlin("plugin.spring") version "1.7.10"
  kotlin("plugin.serialization") version "1.7.10"
}
dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.6.4")
  implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
  implementation("com.github.demidko:telegram-storage:2022.05.30")
  implementation("org.apache.commons:commons-csv:1.9.0")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.amshove.kluent:kluent:1.68")
  testImplementation("io.mockk:mockk:1.12.4")
}
tasks.compileKotlin {
  kotlinOptions.jvmTarget = "17"
  kotlinOptions.freeCompilerArgs += listOf("-opt-in=kotlin.time.ExperimentalTime", "-Xjsr305=strict")
}
tasks.compileTestKotlin {
  kotlinOptions.jvmTarget = "17"
  kotlinOptions.freeCompilerArgs += listOf("-opt-in=kotlin.time.ExperimentalTime", "-Xjsr305=strict")
}
tasks.test {
  useJUnitPlatform()
}
tasks.bootJar {
  archiveVersion.set("boot")
}