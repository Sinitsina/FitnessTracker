package org.fitnesstracker.FitnessTracker.service;

import lombok.RequiredArgsConstructor;
import org.fitnesstracker.FitnessTracker.dto.WorkoutCategoryDTO;
import org.fitnesstracker.FitnessTracker.exceptions.EntityNotFoundException;
import org.fitnesstracker.FitnessTracker.mapper.WorkoutCategoryMapper;
import org.fitnesstracker.FitnessTracker.model.WorkoutCategory;
import org.fitnesstracker.FitnessTracker.repository.WorkoutCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WorkoutCategoryService {

    private WorkoutCategoryRepository workoutCategoryRepository;

    private WorkoutCategoryMapper workoutCategoryMapper;

    @Autowired
    public WorkoutCategoryService(WorkoutCategoryRepository workoutCategoryRepository,
                                  WorkoutCategoryMapper workoutCategoryMapper) {
        this.workoutCategoryRepository = workoutCategoryRepository;
        this.workoutCategoryMapper = workoutCategoryMapper;
    }

    /**
     * Get list of all categories
     */
    public List<WorkoutCategoryDTO> viewAllCategories() {

        return workoutCategoryMapper.workoutCategoryListToWorkoutCategoryDTOList(
                workoutCategoryRepository.findAll());
    }

    /**
     * Add new category
     */
    public WorkoutCategoryDTO addCategory(WorkoutCategoryDTO workoutCategoryDTO) {

        WorkoutCategory workoutCategory =
                workoutCategoryMapper.workoutCategoryDTOToWorkoutCategory(workoutCategoryDTO);

        workoutCategoryRepository.save(workoutCategory);

        return workoutCategoryMapper.workoutCategoryToWorkoutCategoryDTO(workoutCategory);
    }

    /**
     * Edit category
     */
    public WorkoutCategoryDTO editCategory(Long id, WorkoutCategoryDTO workoutCategoryDTO) {

        WorkoutCategory workoutCategory = workoutCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The category id  " + id + " was not found"));

        workoutCategoryDTO.setId(id);

        workoutCategoryRepository.save(workoutCategoryMapper.workoutCategoryDTOToWorkoutCategory(workoutCategoryDTO));

        return workoutCategoryMapper.workoutCategoryToWorkoutCategoryDTO(workoutCategory);
    }

    /**
     * Delete category (change isDeleted parameter to true)
     */
    public void deleteCategory(Long id) {

        WorkoutCategory workoutCategory = workoutCategoryRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("The category id " + id + " wasn't found"));

        workoutCategory.setDeleted(true);

        workoutCategoryRepository.save(workoutCategory);
    }
}
