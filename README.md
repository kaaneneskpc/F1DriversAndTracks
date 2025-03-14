# F1 Drivers App 🏎️

A modern Android application that provides comprehensive information about Formula 1 drivers, circuits, and news. Built with Jetpack Compose and following clean architecture principles.

## Overview

![image](https://github.com/user-attachments/assets/0956b40d-e60d-4fe2-8bc3-e0589f6075e8)

F1 Drivers App is your one-stop destination for everything Formula 1. Stay updated with the latest driver information, explore famous circuits, and keep track of your favorite drivers.

## Tech Stack

- **Kotlin** - Primary programming language
- **Jetpack Compose** - Modern UI toolkit for native Android UI
- **Material 3** - Latest Material Design components and theming
- **Hilt** - Dependency injection
- **Room Database** - Local data storage
- **Kotlin Coroutines & Flow** - Asynchronous programming
- **Clean Architecture** - Project architecture pattern
- **MVVM** - Presentation layer pattern

## Architecture Details

The project follows Clean Architecture principles and is organized into three main layers:

### 1. Data Layer
- Handles data operations
- Contains repositories implementations
- Manages local database (Room)
- Handles API calls
- Data mapping between layers

### 2. Domain Layer
- Contains business logic
- Use cases
- Repository interfaces
- Domain models

### 3. Presentation Layer
- MVVM pattern
- UI components
- ViewModels
- State management
- Jetpack Compose UI

### Key Components
- **Dependency Injection**: Hilt for dependency management
- **Navigation**: Jetpack Navigation Compose
- **Database**: Room for local storage
- **Network**: Retrofit for API calls
- **Asynchronous Operations**: Coroutines and Flow

## Features

### 🏃 Drivers
- Browse comprehensive list of F1 drivers
- View detailed driver information
- Search drivers by name
- Driver statistics and career highlights

### ❤️ Favorites
- Add drivers to favorites
- Quick access to favorite drivers
- Manage favorite drivers list
- Persistent storage of favorites

### 🏁 Circuits
- Explore F1 race circuits
- Detailed circuit information
- Circuit characteristics and history
- Visual circuit layouts

### 📰 News
- Latest F1 news updates
- News article previews
- Web view for full article reading
- Stay updated with F1 world

### 🎨 UI/UX
- Modern Material 3 design
- Dark/Light theme support
- Smooth animations and transitions
- Intuitive navigation
- Gradient backgrounds
- Responsive layout

## App Content Video
[Screen_recording_20250102_011647.webm](https://github.com/user-attachments/assets/45f2b0fb-75f6-49c0-ad58-391c8a1cde62)

## Installation

### Prerequisites
- Android Studio Hedgehog | 2023.1.1 or newer
- Minimum SDK Level 24
- Target SDK Level 35
- Gradle 8.5
- News API Key (Required for news functionality)

### Getting Started
1. Get a News API Key at [https://newsapi.org](https://newsapi.org)
2. Create a `local.properties` file in the root directory if not exists
3. Add your API key in `local.properties`:
   ```properties
   NEWS_API_KEY=your_api_key_here
   ```

Clone the repository
```kotlin
https://github.com/kaaneneskpc/F1DriversAndTracks.git
```
Open In Android Studio, Click on File > Open and select the cloned project directory.

Add the dependency to your `libs.versions.toml` file:

```kotlin
[versions]
accompanistSwiperefresh = "0.36.0"
agp = "8.5.0"
coilCompose = "2.7.0"
converterGson = "2.9.0"
converterMoshi = "2.9.0"
desugar_jdk_libs = "1.1.5"
hiltAndroid = "2.52"
hiltCompiler = "1.2.0"
hiltPlugin = "2.52"
kotlin = "2.0.0"
coreKtx = "1.13.1"
kotlinxCoroutinesAndroid = "1.8.1"
kotlinxCoroutinesCore = "1.8.1"
lifecycleRuntimeKtx = "2.8.4"
activityCompose = "1.9.1"
composeBom = "2024.06.00"
loggingInterceptor = "4.12.0"
loggingInterceptorVersion = "5.0.0-alpha.3"
material = "1.6.1"
materialIconsExtended = "1.6.8"
navigationCompose = "2.8.0-beta01"
okhttp = "4.12.0"
playServicesLocation = "20.0.0"
retrofit = "2.9.0"
kotlinxSerializationJson = "1.6.3"
roomKtx = "2.6.1"

junit = "4.13.2"
swipe = "1.2.0"
truth = "1.4.2"
testCore = "1.6.1"
coreTesting = "2.2.0"
mockk = "1.13.10"
ui = "1.7.3"
uiTestManifest = "1.6.8"

extJunit = "1.2.1"
testCoreKtx = "1.6.1"
testRunner = "1.6.2"
kotlinxCoroutinesTest = "1.8.1"
espressoCore = "3.6.1"
mockwebserver = "4.9.1"
mockkAndroid = "1.13.10"
hiltAndroidTesting = "2.51.1"
hiltAndroidCompiler = "2.51.1"
ksp = "2.0.0-1.0.22"
material3Android = "1.3.0"
junitKtx = "1.2.1"

[libraries]
androidx-material = { module = "androidx.compose.material:material", version.ref = "material" }
converter-moshi = { module = "com.squareup.retrofit2:converter-moshi", version.ref = "converterMoshi" }
desugar_jdk_libs = { module = "com.android.tools:desugar_jdk_libs", version.ref = "desugar_jdk_libs" }
junit = { module = "junit:junit", version.ref = "junit" }
logging-interceptor-v500alpha3 = { module = "com.squareup.okhttp3:logging-interceptor", version.ref = "loggingInterceptorVersion" }
play-services-location = { module = "com.google.android.gms:play-services-location", version.ref = "playServicesLocation" }
truth = { module = "com.google.truth:truth", version.ref = "truth" }
androidx-core = { module = "androidx.test:core", version.ref = "testCore" }
androidx-core-testing = { module = "androidx.arch.core:core-testing", version.ref = "coreTesting" }
mockk = { module = "io.mockk:mockk", version.ref = "mockk" }
ui-test-manifest = { module = "androidx.compose.ui:ui-test-manifest", version.ref = "uiTestManifest" }

androidx-junit = { module = "androidx.test.ext:junit", version.ref = "extJunit" }
androidx-ui-test-junit4 = { module = "androidx.compose.ui:ui-test-junit4" }
core-ktx = { module = "androidx.test:core-ktx", version.ref = "testCoreKtx" }
androidx-runner = { module = "androidx.test:runner", version.ref = "testRunner" }
kotlinx-coroutines-test = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-test", version.ref = "kotlinxCoroutinesTest" }
androidx-espresso-core = { module = "androidx.test.espresso:espresso-core", version.ref = "espressoCore" }
mockwebserver = { module = "com.squareup.okhttp3:mockwebserver", version.ref = "mockwebserver" }
mockk-android = { module = "io.mockk:mockk-android", version.ref = "mockkAndroid" }
hilt-android-testing = { module = "com.google.dagger:hilt-android-testing", version.ref = "hiltAndroidTesting" }
hilt-android-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "hiltAndroidCompiler" }

androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
androidx-hilt-compiler = { module = "androidx.hilt:hilt-compiler", version.ref = "hiltCompiler" }
androidx-hilt-navigation-compose = { module = "androidx.hilt:hilt-navigation-compose", version.ref = "hiltCompiler" }
androidx-lifecycle-viewmodel-ktx = { module = "androidx.lifecycle:lifecycle-viewmodel-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-material-icons-extended = { module = "androidx.compose.material:material-icons-extended", version.ref = "materialIconsExtended" }
androidx-navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "navigationCompose" }
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "kotlinxSerializationJson" }
androidx-room-compiler = { module = "androidx.room:room-compiler", version.ref = "roomKtx" }
androidx-room-ktx = { module = "androidx.room:room-ktx", version.ref = "roomKtx" }
androidx-room-paging = { module = "androidx.room:room-paging", version.ref = "roomKtx" }
coil-compose = { module = "io.coil-kt:coil-compose", version.ref = "coilCompose" }
converter-gson = { module = "com.squareup.retrofit2:converter-gson", version.ref = "converterGson" }
hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hiltAndroid" }
hilt-compiler = { module = "com.google.dagger:hilt-compiler", version.ref = "hiltAndroid" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest" }
androidx-material3 = { group = "androidx.compose.material3", name = "material3" }
kotlinx-coroutines-android = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-android", version.ref = "kotlinxCoroutinesAndroid" }
kotlinx-coroutines-core = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-core", version.ref = "kotlinxCoroutinesCore" }
logging-interceptor = { module = "com.squareup.okhttp3:logging-interceptor", version.ref = "loggingInterceptor" }
okhttp = { module = "com.squareup.okhttp3:okhttp", version.ref = "okhttp" }
retrofit = { module = "com.squareup.retrofit2:retrofit", version.ref = "retrofit" }
androidx-material3-android = { group = "androidx.compose.material3", name = "material3-android", version.ref = "material3Android" }
androidx-junit-ktx = { group = "androidx.test.ext", name = "junit-ktx", version.ref = "junitKtx" }


[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
jetbrains-kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
daggerHiltAndroid = { id = "com.google.dagger.hilt.android", version.ref = "hiltPlugin" }
jetbrainsKotlinSerialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlin" }
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
compose-compiler = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
```
</br>

Add the dependency to your `build.gradle.kts` file:

```kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.jetbrainsKotlinSerialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.f1drivers"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.f1drivers"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        val properties = org.jetbrains.kotlin.konan.properties.Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        
        buildConfigField("String", "NEWS_API_KEY", "\"${properties.getProperty("NEWS_API_KEY")}\"")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    coreLibraryDesugaring (libs.desugar.jdk.libs)

    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    // Room
    implementation(libs.androidx.room.ktx)
    androidTestImplementation(project(":app"))
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.paging)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Lifecycle ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Dagger - Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    ksp(libs.androidx.hilt.compiler)

    implementation(libs.androidx.hilt.navigation.compose)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // Coil
    implementation(libs.coil.compose)

    // Extended Icons
    implementation(libs.androidx.material.icons.extended)

    implementation (libs.play.services.location)
    implementation (libs.converter.moshi)
    implementation (libs.logging.interceptor.v500alpha3)

    // Pull to Refresh
    implementation(libs.androidx.material)
}
```

## Contributing Guide

### How to Contribute
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Code Style Guidelines
- Follow Kotlin coding conventions
- Use meaningful names for functions and variables
- Write comments for complex logic
- Keep functions small and focused
- Add appropriate unit tests for new features

### Issue Reporting
- Use the GitHub issue tracker
- Clearly describe the issue or bug
- Include steps to reproduce
- Add screenshots if applicable
- Mention your environment details

### Branch Strategy
- `main`: Production-ready code
- `develop`: Development branch
- `feature/*`: New features
- `bugfix/*`: Bug fixes
- `release/*`: Release preparations

## Acknowledgments

- Formula 1 for drivers and tracks inspiration
- Jetpack Compose team for the modern UI toolkit
- Material Design team for design guidelines

## 📝 License

This project is open-source and available under the [MIT License](LICENSE).

## Contact

**Kaan Enes Kapıcı**
- LinkedIn: [Kaan Enes Kapıcı](https://www.linkedin.com/in/kaaneneskpc/)
- GitHub: [@kaaneneskpc](https://github.com/kaaneneskpc)
- Email: kaaneneskpc1@gmail.com

Feel free to reach out for any questions, suggestions, or collaboration opportunities! 
