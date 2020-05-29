#!/bin/bash

git diff --exit-code --quiet --name-only -- "*.scala" "*.sbt" "script/validate.sh" ".travis.yml" ".scalafmt.conf"
sbtBuildRequired=$?

if [ $sbtBuildRequired -ne 0 ]; then
  SCALAJS_VERSION="0.6.33" sbt clean ++$TRAVIS_SCALA_VERSION test;
  SCALAJS_VERSION=""       sbt clean ++$TRAVIS_SCALA_VERSION test;
fi
