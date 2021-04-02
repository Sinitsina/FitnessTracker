package org.fitnesstracker.FitnessTracker.mapper;

import org.fitnesstracker.FitnessTracker.dto.SportActivityDTO;
import org.fitnesstracker.FitnessTracker.model.SportActivity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SportActivityMapper {

    SportActivityMapper INSTANCE = Mappers.getMapper(SportActivityMapper.class);

    SportActivityDTO sportActivityToSportActivityDTO(SportActivity sportActivity);

    SportActivity sportActivityDTOToSportActivity(SportActivityDTO sportActivityDTO);

    List<SportActivityDTO> sportActivityListToSportActivityDTOList(List<SportActivity> sportActivityList);
}
