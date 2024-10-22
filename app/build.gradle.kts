plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.orca"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.orca"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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



allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    dependencies{
       /* detektPlugins(libs.detekt.formatting)
        detektPlugins(libs.detekt.compose.rules)*/
    }


/*    allprojects { project ->
        apply plugin: "io.gitlab.arturbosch.detekt"

        dependencies {
            detektPlugins "com.twitter.compose.rules:detekt:0.0.26"
        }

        detekt {
            toolVersion = "1.23.3"
            config.setFrom("$rootDir/codequality/detekt/detekt.yml")
            buildUponDefaultConfig = false
            allRules = false
            baseline = file("detekt/baseline.xml")
            basePath = projectDir
        }

        // If not set, all file paths reported will be absolute file path.
        tasks.withType(Detekt).configureEach {
            jvmTarget = "1.8"
            reports {
                xml.required = false
                html.required = true
                html.outputLocation = file("detekt/report.html")
                txt.required = false
                sarif.required = false
                md.required = false
            }
            basePath = rootDir.absolutePath
        }*/
}




dependencies {
    implementation(project(":core:design"))
    implementation(project(":features:auth"))
    implementation(project(":features:home"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashScreen)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.kotlinxImmutableCollections)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.tooling)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(platform(libs.androidx.compose.bom))
}