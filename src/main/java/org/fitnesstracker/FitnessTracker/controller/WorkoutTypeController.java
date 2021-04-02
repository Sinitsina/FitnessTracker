package org.fitnesstracker.FitnessTracker.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fitnesstracker.FitnessTracker.dto.WorkoutTypeDTO;
import org.fitnesstracker.FitnessTracker.service.WorkoutTypeService;
import org.fitnesstracker.FitnessTracker.transfer.Exist;
import org.fitnesstracker.FitnessTracker.transfer.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@Api(value = "Workout", tags = {"Workout"})
public class WorkoutTypeController {

    private final WorkoutTypeService workoutTypeService;

    @Autowired
    public WorkoutTypeController(WorkoutTypeService workoutTypeService) {
        this.workoutTypeService = workoutTypeService;
    }


    @GetMapping("/all")
    @ApiOperation("get list of all workouts")
    public ResponseEntity<List<WorkoutTypeDTO>> viewAllWorkouts() {
        return new ResponseEntity<>(workoutTypeService.viewAllWorkouts(), HttpStatus.OK);
    }

    @PostMapping("/add-workout")
    @ApiOperation("add new workout")
    public ResponseEntity<WorkoutTypeDTO> addWorkout(@Validated(New.class)
                                                     @RequestBody WorkoutTypeDTO workoutTypeDTO) {

        return new ResponseEntity<>(workoutTypeService.addWorkout(workoutTypeDTO), HttpStatus.OK);
    }

    @PutMapping("/{workoutId}")
    @ApiOperation("change workout information")
    public ResponseEntity<WorkoutTypeDTO> editWorkout(@PathVariable Long workoutId,
                                                      @Validated(Exist.class)
                                                      @RequestBody WorkoutTypeDTO workoutTypeDTO) {
        return new ResponseEntity<>(workoutTypeService.editWorkout(workoutId, workoutTypeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{workoutId}")
    @ApiOperation("delete workout")
    public void deleteWorkout(@PathVariable Long workoutId) {

        workoutTypeService.deleteWorkout(workoutId);
    }
}
