plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.weatherapp"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.weatherapp"
        minSdk = 23
        targetSdk = 36
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // app/build.gradle.kts -> dentro de dependencies { ... }
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    //kapt("com.github.bumptech.glide:compiler:4.15.1") // se usar annotationProcessor substitua por kapt se necessário
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    implementation("androidx.fragment:fragment-ktx:1.6.0")

}