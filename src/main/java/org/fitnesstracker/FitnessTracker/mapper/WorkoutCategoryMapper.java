package org.fitnesstracker.FitnessTracker.mapper;

import org.fitnesstracker.FitnessTracker.dto.WorkoutCategoryDTO;
import org.fitnesstracker.FitnessTracker.model.WorkoutCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkoutCategoryMapper {

    WorkoutCategoryMapper INSTANCE = Mappers.getMapper(WorkoutCategoryMapper.class);

    WorkoutCategoryDTO workoutCategoryToWorkoutCategoryDTO(WorkoutCategory workoutCategory);

    WorkoutCategory workoutCategoryDTOToWorkoutCategory(WorkoutCategoryDTO workoutCategoryDTO);

    List<WorkoutCategoryDTO> workoutCategoryListToWorkoutCategoryDTOList(List<WorkoutCategory> workoutCategoryList);
}
