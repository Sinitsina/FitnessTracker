package org.fitnesstracker.FitnessTracker.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fitnesstracker.FitnessTracker.dto.WorkoutCategoryDTO;
import org.fitnesstracker.FitnessTracker.service.WorkoutCategoryService;
import org.fitnesstracker.FitnessTracker.transfer.Exist;
import org.fitnesstracker.FitnessTracker.transfer.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workout-category")
@Api(value = "Category", tags = {"Category"})
public class WorkoutCategoryController {

    private final WorkoutCategoryService workoutCategoryService;

    @Autowired
    public WorkoutCategoryController(WorkoutCategoryService workoutCategoryService) {
        this.workoutCategoryService = workoutCategoryService;
    }

    @GetMapping("/all")
    @ApiOperation("get list of all categories")
    public ResponseEntity<List<WorkoutCategoryDTO>> viewAllCategories() {
        return new ResponseEntity<>(workoutCategoryService.viewAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/add-category")
    @ApiOperation("add new category")
    public ResponseEntity<WorkoutCategoryDTO> addCategory(@Validated(New.class)
                                                          @RequestBody WorkoutCategoryDTO workoutCategoryDTO) {

        return new ResponseEntity<>(workoutCategoryService.addCategory(workoutCategoryDTO), HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    @ApiOperation("change category information")
    public ResponseEntity<WorkoutCategoryDTO> editCategory(@PathVariable Long categoryId,
                                                           @Validated(Exist.class)
                                                           @RequestBody WorkoutCategoryDTO workoutCategoryDTO) {
        return new ResponseEntity<>(workoutCategoryService.editCategory(categoryId, workoutCategoryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    @ApiOperation("delete category")
    public void deleteCategory(@PathVariable Long categoryId) {
        workoutCategoryService.deleteCategory(categoryId);
    }
}
