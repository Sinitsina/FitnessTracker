package org.fitnesstracker.FitnessTracker.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "sport_activity")
@Data
public class SportActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Starting time of workout
     */
    @Column(name = "start_time")
    private Time startTime;

    /**
     * Date of workout
     */
    @Column(name = "start_date")
    private LocalDate date;

    /**
     * Ending time of workout
     */
    @Column(name = "end_time")
    private Time endTime;

    /**
     * Ending time of workout
     */
    @Column(name = "comment")
    private String comment;

    /**
     * Status of workout
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private WorkoutStatus workoutStatus;

    /**
     * Type of workout ( one activity - one workout)
     */
    @ManyToOne
    @JoinColumn(name = "workout_type_id")
    private WorkoutType workout;

    @Column(name = "is_deleted")
    private boolean isDeleted;

}
