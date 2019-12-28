package littlepeople.application.service;

import littlepeople.application.model.Activity;
import littlepeople.application.model.Hospital;
import littlepeople.application.model.StatusEnum;
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
        return activityRepository.getAllActivitiesFromCity(city);
    }

    public List<Activity> getAllActivitiesFromHospital(Long hospitalId){
        return activityRepository.getAllActivitesFromHospital(hospitalId);
    }

    public Activity getActivityById(Long id){
        return activityRepository.findById(id).get();
    }

    public void deleteActivityById(Long activityId){
        this.activityRepository.deleteById(activityId);
    }

    public Activity addActivity(Activity activity){
        activity.setStatus(StatusEnum.ACCEPTED.toString());
        return this.activityRepository.save(activity);
    }

    public Activity updateActivity(Activity activity){
        return this.activityRepository.save(activity);
    }
}
