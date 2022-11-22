plugins{
    id("com.google.dagger.hilt.android") version "2.44" apply false
}

buildscript {
    val compose_ui_version by extra("1.1.1")
    val retrofit by extra("2.9.0")
    val gson by extra("2.9.0")
    val okhttp by extra("4.1.0")
    val lifecycle_version by extra("2.4.1")
    val lifecycle_viewmodel_ktx by extra("2.5.0-alpha04")
    val coil by extra("1.3.2")
    val hilt by extra("2.44")

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("com.android.tools.build:gradle:7.3.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}