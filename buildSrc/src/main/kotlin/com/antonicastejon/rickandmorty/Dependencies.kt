package com.antonicastejon.rickandmorty

object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha14"

    object Kotlin {
        private const val version = "1.4.32"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val serialization = "org.jetbrains.kotlin:kotlin-serialization:$version"

        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0"

        object Coroutines {
            private const val version = "1.4.2"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Google {

        object Di {
            private const val version = "2.34-beta"

            const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
            const val hilt = "com.google.dagger:hilt-android:$version"
            const val hiltKapt = "com.google.dagger:hilt-compiler:$version"
        }
    }

    object AndroidX {

        private const val version = "1.2.0"
        const val appcompat = "androidx.appcompat:appcompat:$version"

        object ComposeDependencies {

            private const val version = "1.0.0-beta04"

            const val ui = "androidx.compose.ui:ui:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"

            object Integrations {
                const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha06"
            }
        }
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofitKotlinSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"

        const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:4.9.1"
    }

    object Test {

        object JUnit {
            private const val version = "4.12"
            const val junit = "junit:junit:$version"
        }
    }
}
