# Appium Api Demos Automation.

## Description:
Sample tests executed on Appium Api Demos app with usage of Appium tool.
Tested on elmulators Nexus 5X API 25 and 27

## Environment setup:
Ubuntu 16.04 LTS
IntelliJ IDEA Community 2018.1
Android Studio 3.1
Java 1.8.0_161
Maven 3.3.9
Appium 1.7.1

### Steps to run app and tests:
1.Download project from GitHub and open it in InteliJ.

2.Download sample app from https://apkpure.com/appium-api-demos/io.appium.android.apis and place it in __src__ project foler.

2.Install required dependencies from __pom.xml__.

3.Install required Android SDK Platforms (API 25 or 27) in SDK Manager (Android Studio).

4.Create Emulator with required API in AVD Manager (Android Studio). In my example name of created emulator is __Nexus_5X_API_27__ and this name is used in __desiredCapabilities__, (__BaseAppiumTest__). If you use another name, please change it code.

5.Install Appium tool:
```
$ npm install appium@1.7.1
```

6.Run Appium from Terminal:
```
$ appium
```

7.List created Emulator (got to __platform-tools__ and run the command):
```
$ emulator -list-avds
```

8.Run created emulator:
```
$ emulator -avd name_of_your_emulator
```

9.Run tests in Maven - go to folder where __pom.xml__ is located and enter command in Terminal:
```
$ mvn test
```