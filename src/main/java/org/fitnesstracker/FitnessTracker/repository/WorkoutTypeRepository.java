package org.fitnesstracker.FitnessTracker.repository;

import org.fitnesstracker.FitnessTracker.model.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutTypeRepository extends JpaRepository<WorkoutType, Long> {
}
