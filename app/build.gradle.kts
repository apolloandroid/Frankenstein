plugins {
    id(Plugins.Application.name)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.extensions)
    id(Plugins.Kotlin.kapt)
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode

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

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    //  Core
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.activityKtx)
    implementation(Dependencies.fragmentKtx)
    //  Navigation
    implementation(Dependencies.navigationFragmentKtx)
    implementation(Dependencies.navigationUiKtx)
    implementation(Dependencies.cicerone)
    //  DI
    implementation(Dependencies.koin)
    // Moxy
    implementation(Dependencies.moxy)
    kapt(Dependencies.moxyCompiler)
    implementation(Dependencies.moxyAndroid)
    implementation(Dependencies.moxyAndroidX)
    //  OkHttp
    implementation(Dependencies.okHttpInterceptor)
    //  Retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitRx)
    implementation(Dependencies.retrofitKotlinxConverter)
    implementation(Dependencies.retrofitGsonConverter)
    //  Room
    implementation(Dependencies.room)
    kapt(Dependencies.roomCompiler)
    implementation(Dependencies.roomKtx)
    implementation(Dependencies.roomRx)
    //  RX
    implementation(Dependencies.rxKotlin)
    implementation(Dependencies.rxAndroid)
    //  Serialization
    implementation(Dependencies.kotlinxSerialization)
    //  UI
    implementation(Dependencies.splashScreen)
    implementation(Dependencies.swipeRefreshLayout)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.glide)
    annotationProcessor(Dependencies.glideCompiler)
    //  Tests
    testImplementation(Dependencies.junit)
   androidTestImplementation(Dependencies.junitExt)
   androidTestImplementation(Dependencies.espresso)
}