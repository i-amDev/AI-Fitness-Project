package com.fitness.ai_service.service;

import com.fitness.ai_service.model.Recommendation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendationService {
    List<Recommendation> getUserRecommendation(String userId);

    Recommendation getActivityRecommendation(String activityId);
}
