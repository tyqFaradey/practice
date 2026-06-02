plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)
}

dependencies {
    implementation(project(":core-domain"))
    
    implementation(platform(libs.compose.bom))
    implementation(libs.core.ktx)

    implementation(libs.activity.compose)
    implementation(libs.ui)
    implementation(libs.material3)
}

android {
    namespace = "com.example.core_ui"
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