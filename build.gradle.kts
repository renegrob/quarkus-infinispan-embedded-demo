plugins {
    `java`
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project
val infinispanEmbeddedVersion: String by project
val protostreamVersion: String by project;

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-rest-jackson")
    implementation("io.quarkus:quarkus-config-yaml")
    implementation("io.quarkus:quarkus-container-image-jib")

    implementation("io.quarkiverse.infinispan:quarkus-infinispan-embedded:${infinispanEmbeddedVersion}")
    annotationProcessor("org.infinispan.protostream:protostream-processor:${protostreamVersion}")
    compileOnly("org.infinispan.protostream:protostream-processor:${protostreamVersion}")

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.testcontainers:testcontainers:1.19.1")
}

group = "io.github.renegrob"
version = "1.0.0-SNAPSHOT"



java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
