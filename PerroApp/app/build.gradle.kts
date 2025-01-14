plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.perroapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.perroapp"
        minSdk = 24
        targetSdk = 33
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
}

dependencies {

    dependencies {
        implementation(libs.androidx.core.ktx.v170)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.androidx.recyclerview)
        implementation(libs.androidx.lifecycle.runtime.ktx.v240)
        implementation(libs.ui)
        implementation(libs.material3)
        implementation(libs.ui.tooling.preview)
        implementation(libs.retrofit)
        implementation(libs.converter.gson)
        implementation (libs.io.coil.kt.coil.compose)
        implementation (libs.androidx.activity.compose.v161)
        implementation (libs.androidx.ui.v120)
        implementation (libs.androidx.material3.v100)
        implementation (libs.androidx.ui.tooling.preview.v120)
    }

}