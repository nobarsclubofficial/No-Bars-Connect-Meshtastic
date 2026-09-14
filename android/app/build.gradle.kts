plugins {
    id("com.android.application")
    // START: FlutterFire Configuration
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    // END: FlutterFire Configuration
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

import java.util.Properties
import java.io.FileInputStream
import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension

// The FlutterFire plugins pin the Firebase Android SDK through the BoM version
// declared by firebase_core. Reading the same property keeps this module's
// Firebase artifacts on that BoM instead of carrying a second version pin.
val firebaseSdkVersion = project(":firebase_core").properties["FirebaseSDKVersion"] as String

val keystoreProperties = Properties()
val keystorePropertiesFile = rootProject.file("key.properties")
if (keystorePropertiesFile.exists()) {
    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
}

val nativeCmakeFile = file("src/main/jni/CMakeLists.txt")

android {
    namespace = "com.gotnull.socialmesh"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    // Some upstream branches declare a native build even when the CMake
    // project is not present. Only configure it when the source actually
    // exists so normal Flutter debug builds can proceed.
    if (nativeCmakeFile.exists()) {
        externalNativeBuild {
            cmake {
                version = "3.22.1"
                path = nativeCmakeFile
            }
        }
    }

    signingConfigs {
        create("release") {
            if (keystorePropertiesFile.exists()) {
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
                storeFile = file(keystoreProperties["storeFile"] as String)
                storePassword = keystoreProperties["storePassword"] as String
            }
        }
    }

    defaultConfig {
        // Keep the upstream namespace for native/source compatibility, but use
        // a unique install ID so No Bars Command can coexist with SocialMesh.
        applicationId = "com.nobarsclub.command"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a")
        }
        if (nativeCmakeFile.exists()) {
            externalNativeBuild {
                cmake {
                    cFlags("-O2 -fPIC -std=gnu11")
                }
            }
        }
    }

    buildTypes {
        release {
            signingConfig = if (keystorePropertiesFile.exists()) {
                signingConfigs.getByName("release")
            } else {
                signingConfigs.getByName("debug")
            }
            configure<CrashlyticsExtension> {
                nativeSymbolUploadEnabled = true
            }
        }
    }
}

tasks.matching { it.name == "bundleRelease" || it.name == "assembleRelease" }.configureEach {
    finalizedBy("uploadCrashlyticsSymbolFileRelease")
}

flutter {
    source = "../.."
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.4")
    implementation(platform("com.google.firebase:firebase-bom:$firebaseSdkVersion"))
    implementation("com.google.firebase:firebase-crashlytics-ndk")
    implementation("com.google.firebase:firebase-messaging:23.4.0")
    implementation("androidx.activity:activity-ktx:1.10.1")
}
