plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.drr.mypetsstore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.drr.mypetsstore"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation("org.projectlombok:lombok:1.18.28");
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.11.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.2.0-alpha13")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}