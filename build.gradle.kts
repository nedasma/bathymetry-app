// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.dagger.hilt) version "2.51.1" apply false
    alias(libs.plugins.kotlin.serialization) version "1.9.0" apply false
}