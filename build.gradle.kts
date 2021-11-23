import de.itemis.mps.gradle.downloadJBR.DownloadJbrForPlatform
import de.itemis.mps.gradle.BuildLanguages

buildscript {
    repositories {
        maven { url = uri("https://projects.itemis.de/nexus/content/repositories/mbeddr") }
        mavenCentral()
    }

    dependencies {
        classpath("de.itemis.mps:mps-gradle-plugin:1.5+")
    }
}

plugins {
    //id("download-jbr") version "1.5.269.964f94a"
}

repositories {
    maven { url = uri("https://projects.itemis.de/nexus/content/repositories/mbeddr") }
    mavenCentral()
}

val mbeddr: Configuration by configurations.creating
val iets3: Configuration by configurations.creating
val mps: Configuration by configurations.creating

// dependency versions
val mpsVersion = "2020.3.5"
val iets3Version = "2020.3.+"
val mbeddrVersion = "2020.3.+"

dependencies {
    iets3("org.iets3:opensource:$iets3Version")
    mbeddr("com.mbeddr:platform:$mbeddrVersion")
    mps("com.jetbrains:mps:$mpsVersion")
}

val mpsDir = file("$buildDir/mps")
val artifactsDir = file("$buildDir/artifacts")
val jbrDir = file("$buildDir/jbr")

/*downloadJbr {
    jbrVersion = "11_0_10-b1145.96"
    downloadDir = jbrDir
}*/

val extractMps by tasks.registering(Copy::class) {
    from({ mps.resolve().map { zipTree(it) } })
    into(mpsDir)
}

val extractMpsDependencies by tasks.registering(Copy::class) {
    from({
        mbeddr.resolve().map { zipTree(it) }
        iets3.resolve().map { zipTree(it) }
    })

    into(artifactsDir)
}

fun antVar(name: String, value: String)  = "-D$name=$value"

val setup by tasks.registering {
    group = "Setup"
    description = "Download and extract MPS and the projects MPS dependencies."
    dependsOn(extractMps)
    dependsOn(extractMpsDependencies)
    /*val downloadJbrForPlatform = tasks.getByName("downloadJbr", DownloadJbrForPlatform::class)
    dependsOn(downloadJbrForPlatform)
    ext["itemis.mps.gradle.ant.defaultJavaExecutable"] = downloadJbrForPlatform.javaExecutable
    ext["itemis.mps.gradle.ant.defaultScriptArgs"] =
        listOf(
            antVar("mps_home", mpsDir.absolutePath),
            antVar("artifacts_home", artifactsDir.absolutePath),
            antVar("mps.generator.skipUnmodifiedModels", "true")
        )
    ext["itemis.mps.gradle.ant.defaultScriptClasspath"] = buildDependencies.fileCollection { true }*/
}

/*
val buildScripts by tasks.registering(BuildLanguages::class) {
    dependsOn(setup)
    script = "$projectDir/build-allScripts.xml"
}

val buildLanguages by tasks.registering(BuildLanguages::class) {
    group = "build"
    description = "Build all languages in the MPS project"
    script = "$buildDir/scripts/build.xml"
    dependsOn(buildScripts)
}*/
