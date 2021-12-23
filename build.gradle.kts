plugins {
    `maven-publish`
    signing
    id("org.jetbrains.kotlin.jvm").version("1.6.10")
    id("io.github.gradle-nexus.publish-plugin").version("1.1.0")
    id("org.jetbrains.dokka").version("1.6.0")
}

group = "com.doist"
version = property("version") as String

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.pinterest.ktlint:ktlint-core:0.43.2")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.named<Jar>("javadocJar") {
    from(tasks.dokkaJavadoc.get().outputDirectory.get())
    dependsOn(tasks.dokkaJavadoc)
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(signingKey, signingPassword)
    }
    sign(publishing.publications)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])

            pom {
                name.set(project.name)
                description.set("Ktlint Idea Reporter")
                url.set("https://github.com/Doist/ktlint-idea-reporter")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                scm {
                    url.set("https://github.com/Doist/ktlint-idea-reporter")
                    connection.set("scm:git:git://github.com/Doist/ktlint-idea-reporter.git")
                    developerConnection.set("scm:git:ssh://git@github.com/Doist/ktlint-idea-reporter.git")
                }
                developers {
                    developer {
                        id.set("doist")
                        name.set("Doist Inc.")
                    }
                }
            }
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            val ossrhUsername: String? by project
            val ossrhPassword: String? by project
            val ossrhStagingProfileId: String? by project
            username.set(ossrhUsername)
            password.set(ossrhPassword)
            stagingProfileId.set(ossrhStagingProfileId)
        }
    }
}
