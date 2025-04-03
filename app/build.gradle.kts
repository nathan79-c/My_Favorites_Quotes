plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)


    id("com.google.devtools.ksp") version "2.1.10-1.0.31"
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")

    // Kotlin serialization plugin for type safe routes and navigation arguments

    kotlin("plugin.serialization") version "2.1.20"
}

android {
    namespace = "com.example.myfavoritesquotes"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myfavoritesquotes"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // glance dependancies
    // For AppWidgets support
    implementation (libs.androidx.glance.appwidget)

    // For interop APIs with Material 3
    implementation (libs.glance.material3)

    // Koin for Android
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.androidx.startup)

    implementation("io.insert-koin:koin-android:3.5.0")
    implementation ("io.insert-koin:koin-androidx-compose:3.5.0")




    // Navigation

    implementation(libs.androidx.navigation.compose)
    // JSON serialization library, works with the Kotlin serialization plugin dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")

    // Dagger hilt

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    // statup
    implementation("androidx.startup:startup-runtime:1.1.1")


    // Room dependencies


    implementation(libs.androidx.room.runtime)

    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    // See Add the KSP plugin to your project
    ksp(libs.androidx.room.room.compiler2)

    // If this project only uses Java source, use the Java annotationProcessor
    // No additional plugins are necessary
    annotationProcessor(libs.androidx.room.room.compiler2)

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.room.ktx)

    // optional - RxJava2 support for Room
    implementation(libs.room.rxjava2)

    // optional - RxJava3 support for Room
    implementation(libs.room.rxjava3)

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation(libs.room.guava)

    // optional - Test helpers
    testImplementation(libs.room.testing)

    // optional - Paging 3 Integration
    implementation(libs.room.paging)

    // Viewmodel dependecies



    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // ViewModel utilities for Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // LiveData
    implementation(libs.lifecycle.livedata.ktx)
    // Lifecycles only (without ViewModel or LiveData)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    // Lifecycle utilities for Compose
    implementation(libs.androidx.lifecycle.runtime.compose)

    // Saved state module for ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)

    // Annotation processor
    ksp(libs.androidx.lifecycle.compiler)
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation(libs.lifecycle.common.java8)

    // optional - helpers for implementing LifecycleOwner in a Service
    implementation(libs.androidx.lifecycle.service)

    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation(libs.androidx.lifecycle.process)

    // optional - ReactiveStreams support for LiveData
    implementation(libs.androidx.lifecycle.reactivestreams.ktx)

    // optional - Test helpers for LiveData
    testImplementation(libs.androidx.core.testing)

    // optional - Test helpers for Lifecycle runtime
    testImplementation (libs.androidx.lifecycle.runtime.testing)
}
kapt {
    correctErrorTypes = true
}
// Compile time check
ksp {
arg("KOIN_CONFIG_CHECK","true")
}