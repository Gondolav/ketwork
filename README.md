[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0) [![API](https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=23) [![Ketwork](https://jitpack.io/v/Gondolav/ketwork.svg)](https://jitpack.io/#Gondolav/ketwork)

# Ketwork
A network manager written in Kotlin for Android.

## Download

Add the code below to your **root** `build.gradle` file (not your module build.gradle file).

```gradle
allprojects {
    repositories {
      maven { url 'https://jitpack.io' }
    }
}
```

The, add the code below to your **module**'s `build.gradle` file.

```gradle
dependencies {
    implementation 'com.github.Gondolav:ketwork:1.0.0'
}
```

## Usage

Ketwork defines various Android [Context](https://developer.android.com/reference/android/content/Context) extension functions to ease development tied to connectivity.

Here's how to execute some code based on whether Internet connection is on/off:

```kotlin
// Inside an Activity onCreate(), for example
runOnConnection {
    on {
        // download something from the web
    }
    
    off {
        // show error popup
    }
}
```

You can also use `runIfConnected` and `runIfDisconnected`:

```kotlin
runIfConnected {
    // download something from the web
}

runIfDisconnected {
    // show error popup
}
```

Of course, you can also just check for connectivity with `isInternetConnectionOn()`.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
