package org.fitnesstracker.FitnessTracker.service;

import lombok.RequiredArgsConstructor;
import org.fitnesstracker.FitnessTracker.dto.SportActivityDTO;
import org.fitnesstracker.FitnessTracker.exceptions.EntityNotFoundException;
import org.fitnesstracker.FitnessTracker.mapper.SportActivityMapper;
import org.fitnesstracker.FitnessTracker.model.SportActivity;
import org.fitnesstracker.FitnessTracker.model.WorkoutStatus;
import org.fitnesstracker.FitnessTracker.repository.SportActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportActivityService {

    private SportActivityRepository sportActivityRepository;

    private SportActivityMapper sportActivityMapper;

    @Autowired
    public SportActivityService(SportActivityRepository sportActivityRepository,
                                SportActivityMapper sportActivityMapper) {
        this.sportActivityRepository = sportActivityRepository;
        this.sportActivityMapper = sportActivityMapper;
    }

    /**
     * Get activity by status
     */
    public List<SportActivityDTO> getActivitiesByStatus(WorkoutStatus status) {

        List<SportActivity> finishedActivitiesList = sportActivityRepository.findAll()
                .stream()
                .filter(e -> e.getWorkoutStatus().equals(status))
                .collect(Collectors.toList());

        return sportActivityMapper.sportActivityListToSportActivityDTOList(finishedActivitiesList);
    }

    /**
     * Get activity by status and date
     */
    public List<SportActivityDTO> getActivitiesByStatusDate(WorkoutStatus status, LocalDate date) {

        List<SportActivity> activitiesList = sportActivityRepository.findAll()
                .stream()
                .filter(e -> e.getWorkoutStatus().equals(status))
                .filter(e -> e.getDate().equals(date))
                .collect(Collectors.toList());

        return sportActivityMapper.sportActivityListToSportActivityDTOList(activitiesList);
    }

    /**
     * Get list of all activities
     */
    public List<SportActivityDTO> viewAllActivities() {

        return sportActivityMapper.sportActivityListToSportActivityDTOList(
                sportActivityRepository.findAll());
    }

    /**
     * Add new activity
     */
    public SportActivityDTO addActivity(SportActivityDTO sportActivityDTO) {

        SportActivity sportActivity = sportActivityMapper.sportActivityDTOToSportActivity(sportActivityDTO);

        sportActivityRepository.save(sportActivity);

        return sportActivityMapper.sportActivityToSportActivityDTO(sportActivity);
    }

    /**
     * Change activity
     */
    public SportActivityDTO editActivity(Long id, SportActivityDTO sportActivityDTO) {

        SportActivity sportActivity = sportActivityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The activity id  " + id + " was not found"));

        sportActivityDTO.setId(id);

        sportActivityRepository.save(sportActivityMapper.sportActivityDTOToSportActivity(sportActivityDTO));

        return sportActivityMapper.sportActivityToSportActivityDTO(sportActivity);
    }

    /**
     * Delete activity (change isDeleted parameter to true)
     */
    public void deleteActivity(Long id) {

        SportActivity sportActivity = sportActivityRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("The activity id " + id + " wasn't found"));

        sportActivity.setDeleted(true);

        sportActivityRepository.save(sportActivity);
    }

}
