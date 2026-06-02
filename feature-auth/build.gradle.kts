plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)

    alias(libs.plugins.hilt)
    alias(libs.plugins.serialization)
}

dependencies {
    implementation(project(":core-common"))
    implementation(project(":core-domain"))
    implementation(project(":core-utils"))
    implementation(project(":core-ui"))
    implementation(project(":core-validation"))
    implementation(project(":core-network"))

    implementation(platform(libs.compose.bom))

    implementation(libs.ui)
    implementation(libs.material3)

    implementation(libs.navigation.compose)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
}

android {
    namespace = "com.example.feature_auth"
    compileSdk = 36

    buildFeatures {
        compose = true
    }
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