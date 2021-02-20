buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven( url = "https://dl.bintray.com/icerockdev/plugins")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath ("dev.icerock.moko:network-generator:0.9.3")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url = "https://dl.bintray.com/icerockdev/moko")
    }
}