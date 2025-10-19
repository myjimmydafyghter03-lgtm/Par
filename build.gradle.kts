plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.jym.supervpn"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jym.supervpn"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.9.0")
    // Add your VPN backend dependency here, for example:
    // For WireGuard (example): implementation("com.wireguard:wireguard-android:1.0.2023.1")
    // For OpenVPN (example using a wrapper): implementation("net.openvpn:openvpn:3.2.0")
}
