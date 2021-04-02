package org.fitnesstracker.FitnessTracker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.fitnesstracker.FitnessTracker.model.WorkoutStatus;
import org.fitnesstracker.FitnessTracker.model.WorkoutType;
import org.fitnesstracker.FitnessTracker.transfer.Exist;
import org.fitnesstracker.FitnessTracker.transfer.New;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.sql.Time;
import java.util.Date;

@Data
public class SportActivityDTO {

    @Null(groups = {New.class, Exist.class})
    private Long id;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class, Exist.class})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time startTime;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class, Exist.class})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class, Exist.class})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time endTime;

    @NotBlank(message = "Please correctly fill out the field", groups = {Exist.class})
    private String comment;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class, Exist.class})
    private WorkoutStatus workoutStatus;

    @NotBlank(message = "Please correctly fill out the field", groups = {New.class})
    private WorkoutType workout;
}
