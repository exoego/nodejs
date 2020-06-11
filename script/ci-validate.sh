#!/bin/bash

SCALAJS_VERSION="0.6.33" sbt ++$TRAVIS_SCALA_VERSION test

if [[ $TRAVIS_SCALA_VERSION = 2.13.* ]]; then
  SCALAJS_VERSION="" sbt ++$TRAVIS_SCALA_VERSION coverage test coverageReport;
else
  SCALAJS_VERSION="" sbt ++$TRAVIS_SCALA_VERSION test;
fi
