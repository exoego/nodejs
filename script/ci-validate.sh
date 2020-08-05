#!/bin/bash

sbt ++$TRAVIS_SCALA_VERSION test

if [[ $TRAVIS_SCALA_VERSION = 2.13.* ]]; then
  SCALAJS_VERSION="" sbt ++$TRAVIS_SCALA_VERSION coverage test coverageReport;
else
  SCALAJS_VERSION="" sbt ++$TRAVIS_SCALA_VERSION test;
fi
