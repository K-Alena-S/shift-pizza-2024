plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.example.shift_pizza_2024"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.shift_pizza_2024"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.material3.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Навигация с Compose
    implementation(libs.androidx.navigation.compose)

    // Работа с сетью
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.kotlinxserialization)
    implementation(libs.okhttp.logginginterceptor)

    // Сериализация JSON
    implementation(libs.kotlinx.serialization.json)

    // Асинхронное программирование
    implementation(libs.kotlinx.coroutines.android)

    // Unit-тестирование
    testImplementation(libs.junit)
    implementation(libs.kotlinx.coroutines.test)

    // UI-тестирование
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Превью для Compose
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}