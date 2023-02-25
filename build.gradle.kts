// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id(Plugins.Application.name) version Plugins.Application.version apply false
    id(Plugins.AndroidLibrary.name) version Plugins.AndroidLibrary.version apply false
    id(Plugins.Kotlin.androidJetbrains) version Plugins.Kotlin.version apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}