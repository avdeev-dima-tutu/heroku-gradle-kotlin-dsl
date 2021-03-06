plugins {
//  base
//  java
  kotlin("jvm") version "1.2.21"// apply false
}
version = "1.0-SNAPSHOT"

buildscript {
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.21")
  }
}

repositories {
  mavenCentral()
}

dependencies {
  compile("org.jetbrains.kotlin:kotlin-stdlib:1.2.21")
  compile("com.sparkjava:spark-core:+")
  compile("org.slf4j:slf4j-simple:+")
}

task("copyToLib") {
  doLast {
    copy {
      into("$buildDir/libs")
      from(configurations.compile)
    }
  }
}

task("stage") {
//todo  dependsOn.add("clean")
  dependsOn.add("build")
  dependsOn.add("copyToLib")
}

//todo build.mustRunAfter clean
