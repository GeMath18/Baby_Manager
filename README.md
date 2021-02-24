# BabyManager

> BabyManager is an Android app. Baby Manager will help you keep track of all things baby! 

> User can keep track of baby's feeding, diaper change, sleep and user's self care.

> Tech Stack: Java and Android SDK

## Table of Contents
- [Java and Android SDK ](#java-and-android-sdk)
- [App Features](#app-features)
- [FAQ](#faq)
- [Trello Link](#trello-link)

## Java and Android SDK 

- [Room Database](#room-database)

## Room Database
> Room database was used to save the activities from each option of the app. Main components of room: Entity, Dao and Database. 

Dependencies added for Room to build.gradle
```shell
def room_version = "2.2.6"

  implementation "androidx.room:room-runtime:$room_version"
  annotationProcessor "androidx.room:room-compiler:$room_version"

  // optional - RxJava support for Room
  implementation "androidx.room:room-rxjava2:$room_version"

  // optional - Guava support for Room, including Optional and ListenableFuture
  implementation "androidx.room:room-guava:$room_version"

  // optional - Test helpers
  testImplementation "androidx.room:room-testing:$room_version"
```



## Trello Link
- [BabyManager trello link](https://trello.com/b/BQVyHWZC/gessicas-capstone)
