package org.fitnesstracker.FitnessTracker.dto;

import lombok.Data;
import org.fitnesstracker.FitnessTracker.transfer.Exist;
import org.fitnesstracker.FitnessTracker.transfer.New;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class WorkoutCategoryDTO {

    @Null(groups = {New.class, Exist.class})
    private Long id;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class, Exist.class})
    private String categoryName;
}
