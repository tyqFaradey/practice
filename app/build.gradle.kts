plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)

    alias(libs.plugins.hilt)
    alias(libs.plugins.serialization)
}

dependencies {
    implementation(project(":core-ui"))
    implementation(project(":feature-auth"))
    implementation(project(":feature-users"))
    implementation(project(":feature-calculation"))
    implementation(project(":feature-deposits"))

    implementation(platform(libs.compose.bom))
    implementation(libs.core.ktx)

    implementation(libs.activity.compose)
    implementation(libs.navigation.compose)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.ui)
    implementation(libs.material3)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
}

android {
    namespace = "com.example.app"
    compileSdk = 36

    buildFeatures {
        compose = true
    }


    defaultConfig {
        applicationId = "com.example.app"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

