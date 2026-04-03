package com.fitness.activity_service.service.impl;

import com.fitness.activity_service.dto.ActivityRequest;
import com.fitness.activity_service.dto.ActivityResponse;
import com.fitness.activity_service.model.Activity;
import com.fitness.activity_service.service.ActivityService;
import com.fitness.activity_service.service.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    @Override
    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        Activity activity = Activity.builder()
                .userId(activityRequest.getUserId())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .type(activityRequest.getType())
                .duration(activityRequest.getDuration())
                .startTime(activityRequest.getStartTime())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);

        ActivityResponse activityResponse = ActivityResponse.builder()
                .id(savedActivity.getId())
                .userId(savedActivity.getUserId())
                .type(savedActivity.getType())
                .duration(savedActivity.getDuration())
                .caloriesBurned(savedActivity.getCaloriesBurned())
                .startTime(savedActivity.getStartTime())
                .additionalMetrics(savedActivity.getAdditionalMetrics())
                .createdAt(savedActivity.getCreatedAt())
                .updatedAt(savedActivity.getUpdatedAt())
                .build();

        return activityResponse;
    }
}
