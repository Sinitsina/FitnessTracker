package org.fitnesstracker.FitnessTracker.repository;

import org.fitnesstracker.FitnessTracker.model.WorkoutCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutCategoryRepository extends JpaRepository<WorkoutCategory, Long> {
}
