package org.fitnesstracker.FitnessTracker.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fitnesstracker.FitnessTracker.dto.SportActivityDTO;
import org.fitnesstracker.FitnessTracker.model.WorkoutStatus;
import org.fitnesstracker.FitnessTracker.service.SportActivityService;
import org.fitnesstracker.FitnessTracker.transfer.Exist;
import org.fitnesstracker.FitnessTracker.transfer.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
@Api(value = "Activities", tags = {"Activities"})
public class SportActivityController {

    private final SportActivityService sportActivityService;

    @Autowired
    public SportActivityController(SportActivityService sportActivityService) {
        this.sportActivityService = sportActivityService;
    }

    @GetMapping("/all-status/{status}")
    @ApiOperation("get activity by status")
    public ResponseEntity<List<SportActivityDTO>> getActivitiesByStatus(@PathVariable WorkoutStatus status) {
        return new ResponseEntity<>(sportActivityService.getActivitiesByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/all-status-date/{status}/{date}")
    @ApiOperation("get list of all workouts")
    public ResponseEntity<List<SportActivityDTO>> getActivitiesByStatusDate(@PathVariable WorkoutStatus status,
                                                                            @PathVariable("date")
                                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                    LocalDate date) {
        return new ResponseEntity<>(sportActivityService.getActivitiesByStatusDate(status, date), HttpStatus.OK);
    }

    @GetMapping("/all")
    @ApiOperation("get list of all workouts")
    public ResponseEntity<List<SportActivityDTO>> viewAllActivities() {
        return new ResponseEntity<>(sportActivityService.viewAllActivities(), HttpStatus.OK);
    }

    @PostMapping("/add-activity")
    @ApiOperation("add new activity")
    public ResponseEntity<SportActivityDTO> addActivity(@Validated(New.class)
                                                        @RequestBody SportActivityDTO sportActivityDTO) {

        return new ResponseEntity<>(sportActivityService.addActivity(sportActivityDTO), HttpStatus.OK);
    }

    @PutMapping("/{activityId}")
    @ApiOperation("change activity information")
    public ResponseEntity<SportActivityDTO> editActivity(@PathVariable Long activityId,
                                                         @Validated(Exist.class)
                                                         @RequestBody SportActivityDTO sportActivityDTO) {

        return new ResponseEntity<>(sportActivityService.editActivity(activityId, sportActivityDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{activityId}")
    @ApiOperation("delete activity")
    public void deleteActivity(@PathVariable Long activityId) {
        sportActivityService.deleteActivity(activityId);
    }
}
