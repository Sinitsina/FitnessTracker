[![Build Status](https://travis-ci.org/Sinitsina/FitnessTracker.svg?branch=master)](https://travis-ci.org/Sinitsina/FitnessTracker)
# FitnessTracker

This is a java web application for tracking workouts. The application allows you to add different types of categories of workouts, information about a specific training session, get a list of planned and completed workouts.

## Fitness Tracker is a simple REST API that has the capabilities to:

[Sport Activity](https://github.com/Sinitsina/FitnessTracker/blob/master/src/main/java/org/fitnesstracker/FitnessTracker/controller/SportActivityController.java):
-get list of workouts by status or/and date,
- create a workout,
- update a workout,
- delete a workout,
- get list of workouts by status or/and date,

[Category of workout](https://github.com/Sinitsina/FitnessTracker/blob/master/src/main/java/org/fitnesstracker/FitnessTracker/controller/WorkoutCategoryController.java):
- create a category,
- update a category,
- delete a category,
- get data about category.

[Specific training session](https://github.com/Sinitsina/FitnessTracker/blob/master/src/main/java/org/fitnesstracker/FitnessTracker/controller/WorkoutTypeController.java):
- create a training session,
- update a training session,
- delete a training session,
- get data about training session.

## Api_endpoints_documentation
[ScreenShot](Swagger.png)

