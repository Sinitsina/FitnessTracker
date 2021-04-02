package org.fitnesstracker.FitnessTracker.mapper;

import org.fitnesstracker.FitnessTracker.dto.WorkoutTypeDTO;
import org.fitnesstracker.FitnessTracker.model.WorkoutType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkoutTypeMapper {

    WorkoutTypeMapper INSTANCE = Mappers.getMapper(WorkoutTypeMapper.class);

    WorkoutTypeDTO workoutTypeToWorkoutTypeDTO(WorkoutType workoutType);

    WorkoutType workoutTypeDTOToWorkoutType(WorkoutTypeDTO workoutTypeDTO);

    List<WorkoutTypeDTO> workoutTypeListToWorkoutTypeDTOList(List<WorkoutType> workoutTypeList);
}
