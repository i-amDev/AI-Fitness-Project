package com.fitness.activity_service.service;

import com.fitness.activity_service.dto.ActivityRequest;
import com.fitness.activity_service.dto.ActivityResponse;
import org.springframework.stereotype.Service;

@Service
public interface ActivityService {
    ActivityResponse trackActivity(ActivityRequest activityRequest);
}
