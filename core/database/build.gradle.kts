plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)

}

android {
    namespace = "com.orca.database"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
  /*  room {
        schemaDirectory("$projectDir/schemas")
    }*/

}

dependencies {
    implementation(libs.androidx.room)
    implementation(libs.hilt.android)
    implementation(libs.datastore.preferences)
    ksp(libs.hilt.android.compiler)
    ksp(libs.androidx.room.processor)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}