plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.softwaret.mvi.android"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_ui_version"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${rootProject.extra["compose_ui_version"]}")
    implementation("androidx.compose.material:material:1.1.1")
    implementation("com.squareup.retrofit2:retrofit:${rootProject.extra["retrofit"]}")
    implementation("com.squareup.retrofit2:converter-gson:${rootProject.extra["gson"]}")
    implementation("com.squareup.okhttp3:okhttp:${rootProject.extra["okhttp"]}")
    implementation("com.squareup.okhttp3:logging-interceptor:${rootProject.extra["okhttp"]}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${rootProject.extra["lifecycle_viewmodel_ktx"]}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${rootProject.extra["lifecycle_version"]}")
    implementation ("io.coil-kt:coil-compose:${rootProject.extra["coil"]}")
    implementation("com.google.dagger:hilt-android:${rootProject.extra["hilt"]}")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.extra["hilt"]}")
    implementation("androidx.navigation:navigation-compose:2.5.2")

    testImplementation("junit:junit:4.12")
    testImplementation("com.google.truth:truth:0.42")
    testImplementation("org.mockito:mockito-core:3.3.3")
    androidTestImplementation("org.mockito:mockito-android:3.3.3")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.4")

    implementation("io.reactivex.rxjava2:rxkotlin:2.3.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_ui_version"]}")
    debugImplementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_ui_version"]}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${rootProject.extra["compose_ui_version"]}")
}

kapt {
    correctErrorTypes = true
}