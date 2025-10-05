    plugins {
        alias(libs.plugins.android.application)
        alias(libs.plugins.kotlin.android)
        alias(libs.plugins.kotlin.compose)
        alias(libs.plugins.ksp)
        id("kotlin-parcelize")
        alias(libs.plugins.android.hilt)
    }

    android {
        namespace = "com.ashutosh.tajakhabar"
        compileSdk = 36

        defaultConfig {
            applicationId = "com.ashutosh.tajakhabar"
            minSdk = 24
            targetSdk = 35
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
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        kotlinOptions {
            jvmTarget = "17"
        }
        buildFeatures {
            compose = true
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
        implementation(libs.androidx.paging.common.android)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)

        //Splash Api
        implementation("androidx.core:core-splashscreen:1.0.1")

        //datastore
        implementation ("androidx.datastore:datastore-preferences:1.0.0")

        implementation(libs.hilt.android)
        ksp(libs.hilt.compiler)
        implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

        //coroutine
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

        // Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        //coil
        implementation("io.coil-kt:coil-compose:2.4.0")
        //Paging 3
        val paging_version = "3.1.1"
        implementation ("androidx.paging:paging-runtime:$paging_version")
        implementation ("androidx.paging:paging-compose:3.2.0-rc01")

        //RoomDB
        val room_version = "2.5.2"
        implementation ("androidx.room:room-runtime:$room_version")
        ksp("androidx.room:room-compiler:$room_version")
        implementation ("androidx.room:room-ktx:2.5.2")

    }