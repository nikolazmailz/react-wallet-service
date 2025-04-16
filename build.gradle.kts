import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("kapt") version "1.8.22"
}

//configure<KaptExtension> {
//    jvmArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED")
//}

group = "ru.wallet"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

//kapt {
//    jvmArgs("--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED")
//}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.postgresql:r2dbc-postgresql:1.0.0.RELEASE")
    implementation("org.flywaydb:flyway-core")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.7.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
    testImplementation("io.kotest:kotest-assertions-core:5.5.4")
    testImplementation("org.testcontainers:junit-jupiter:1.18.3")
//    testImplementation("org.testcontainers:postgresql:1.18.3")
//    testImplementation("org.testcontainers:h2:1.18.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test")
}

//tasks.withType<Test> {
//    useJUnitPlatform()
//}

tasks.withType<KotlinCompile> {
    kotlinOptions {
//        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

//tasks.withType<org.jetbrains.kotlin.gradle.internal.KaptWithoutKotlincTask>().configureEach {
//    kaptJvmArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED")
//}