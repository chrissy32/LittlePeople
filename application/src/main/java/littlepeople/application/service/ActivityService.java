package littlepeople.application.service;

import littlepeople.application.model.Activity;
import littlepeople.application.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xps 9560
 */

@Service
@RequiredArgsConstructor
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getAllActivitiesFromCity(String city){
        return activityRepository.getAllActivitesFromCity(city);
    }
}
