package org.fitnesstracker.FitnessTracker.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Type of workout for example aero yoga, water aerobics etc
 */
@Entity
@Table(name = "workout_type")
@Data
public class WorkoutType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Workout title
     */
    @Column(name = "workout_title")
    private String workoutTitle;

    /**
     * Notes
     */
    @Column(name = "workout_note")
    private String workoutNote;

    /**
     * Calories burn per minute
     */
    @Column(name = "calories_burn_per_min")
    private double caloriesBurnPerMin;

    /**
     * Workout category
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private WorkoutCategory workoutCategory;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
