plugins {
    id("java")
}

group = "com.pm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // JUnit5
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // RestAssured
    testImplementation("io.rest-assured:rest-assured:5.5.0")
    testImplementation("io.rest-assured:json-path:5.5.0")
    testImplementation("io.rest-assured:xml-path:5.5.0")

    // lombok
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")

    // Jackson

    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")

    // @NotBlank validation и прочая лабуда

    implementation ("org.springframework.boot:spring-boot-starter-validation")

    // API и реализация валидации
    implementation ("org.springframework.boot:spring-boot-starter-validation")
    // ^ Если у вас Spring Boot проект

    // ЕСЛИ У ВАС НЕ SPRING, а просто Java/RestAssured:
    implementation ("org.hibernate.validator:hibernate-validator:8.0.1.Final")
    implementation ("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation ("org.glassfish:jakarta.el:4.0.2") // Нужен для парсинга сообщений


}

tasks.test {
    useJUnitPlatform()
}