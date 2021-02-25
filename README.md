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
---

## App Features

### Overview 

App View | Actions|
--- | :--- | 
![Home Page](Documentation/homescreen.png) | <ul><li>Home Page</li><li>Click any of the four options to start tracking your baby's activities</li></ul>|
![Feeding Options](Documentation/Feedingscreen.png)| <ul><li>4 Feeding Options</li><li>Click on Left or Right side, you have the option to set a date and time. Start a chronometer</li><li>Click on the Bottle option, you have the option to set a date and time. Enter amount in ounces and select between breast milk or formula</li><li>Click on the Supplement option where you may enter and save the description</li><li>User can enter the info needed and save the activity</li></ul>|
![Diaper Change Option](Documentation/diaperscreen.png) | <ul><li>Diaper Change Option</li><li>User can set a date and time</li><li>User select options of the diaper status</li><li>User can enter the info needed and save the activity</li></ul>|




## Trello Link
- [BabyManager trello link](https://trello.com/b/BQVyHWZC/gessicas-capstone)
