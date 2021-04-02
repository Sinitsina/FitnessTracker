package org.fitnesstracker.FitnessTracker.repository;

import org.fitnesstracker.FitnessTracker.model.SportActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportActivityRepository extends JpaRepository<SportActivity, Long> {

}
