plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.ksp)

    alias(libs.plugins.hilt)
}

dependencies {
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
}

android {
    namespace = "com.example.core_validation"
    compileSdk = 36

    defaultConfig {
        minSdk = 29
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

