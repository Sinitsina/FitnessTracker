package org.fitnesstracker.FitnessTracker.dto;

import lombok.Data;
import org.fitnesstracker.FitnessTracker.model.WorkoutCategory;
import org.fitnesstracker.FitnessTracker.transfer.Exist;
import org.fitnesstracker.FitnessTracker.transfer.New;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class WorkoutTypeDTO {

    @Null(groups = {New.class, Exist.class, Exist.class})
    private Long id;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class, Exist.class})
    private String workoutTitle;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class, Exist.class})
    private String workoutNote;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class, Exist.class})
    private double caloriesBurnPerMin;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class, Exist.class})
    private WorkoutCategory workoutCategory;
}
