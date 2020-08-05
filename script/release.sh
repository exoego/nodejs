#! /bin/bash

cat ./version.sbt

sbt clean +publishSigned sonatypeBundleUpload sonatypeReleaseAll
