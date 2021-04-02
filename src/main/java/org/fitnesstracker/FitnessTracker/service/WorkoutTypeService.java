package org.fitnesstracker.FitnessTracker.service;

import lombok.RequiredArgsConstructor;
import org.fitnesstracker.FitnessTracker.dto.WorkoutTypeDTO;
import org.fitnesstracker.FitnessTracker.exceptions.EntityNotFoundException;
import org.fitnesstracker.FitnessTracker.mapper.WorkoutTypeMapper;
import org.fitnesstracker.FitnessTracker.model.WorkoutType;
import org.fitnesstracker.FitnessTracker.repository.WorkoutTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutTypeService {

    private WorkoutTypeRepository workoutTypeRepository;

    private WorkoutTypeMapper workoutTypeMapper;

    @Autowired
    public WorkoutTypeService(WorkoutTypeRepository workoutTypeRepository,
                              WorkoutTypeMapper workoutTypeMapper) {
        this.workoutTypeRepository = workoutTypeRepository;
        this.workoutTypeMapper = workoutTypeMapper;
    }

    /**
     * Get list of all workouts
     */
    public List<WorkoutTypeDTO> viewAllWorkouts() {

        return workoutTypeMapper.workoutTypeListToWorkoutTypeDTOList(
                workoutTypeRepository.findAll());
        // .orElseThrow(() -> new EntityNotFoundException("Any activities weren't found")));
    }

    /**
     * Add new workout
     */
    public WorkoutTypeDTO addWorkout(WorkoutTypeDTO workoutTypeDTO) {

        WorkoutType workoutType =
                workoutTypeMapper.workoutTypeDTOToWorkoutType(workoutTypeDTO);

        workoutTypeRepository.save(workoutType);

        return workoutTypeMapper.workoutTypeToWorkoutTypeDTO(workoutType);
    }

    /**
     * Edit workout
     */
    public WorkoutTypeDTO editWorkout(Long id, WorkoutTypeDTO workoutTypeDTO) {

        WorkoutType workoutType = workoutTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The workout id  " + id + " was not found"));

        workoutTypeDTO.setId(id);

        workoutTypeRepository.save(workoutTypeMapper.workoutTypeDTOToWorkoutType(workoutTypeDTO));

        return workoutTypeMapper.workoutTypeToWorkoutTypeDTO(workoutType);
    }

    /**
     * Delete workout (change isDeleted parameter to true)
     */
    public void deleteWorkout(Long id) {

        WorkoutType workoutType = workoutTypeRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("The workout id " + id + " wasn't found"));

        workoutType.setDeleted(true);

        workoutTypeRepository.save(workoutType);
    }

}
