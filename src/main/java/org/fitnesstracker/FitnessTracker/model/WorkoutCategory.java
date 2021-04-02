package org.fitnesstracker.FitnessTracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "workout_category")
@Data
public class WorkoutCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Category of workout
     */
    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "is_deleted")
    private boolean isDeleted;

}
