package littlepeople.application.mapper;

import littlepeople.application.dto.ActivityDto;
import littlepeople.application.model.Activity;
import littlepeople.application.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityDtoMapper extends AbstractMapper<Activity, ActivityDto> {
    @Autowired
    HospitalService hospitalService;

    @Override
    public Activity convertDtoToModel(ActivityDto activityDto) {
        Activity activity = new Activity();
        activity.setId(activityDto.getId());
        activity.setDescription(activityDto.getDescription());
        activity.setCategory(activityDto.getCategory());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        activity.setStartDateAndTime(LocalDateTime.parse(activityDto.getStartDateAndTime(), formatter));
        activity.setEndDateAndTime(LocalDateTime.parse(activityDto.getEndDateAndTime(), formatter));
        activity.setTitle(activityDto.getTitle());
        activity.setStatus(activityDto.getStatus());
        activity.setHospital(hospitalService.getById(activityDto.getHospitalId()));
        return activity;
    }

    @Override
    public ActivityDto convertModelToDto(Activity activity) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setId(activity.getId());
        activityDto.setDescription(activity.getDescription());
        activityDto.setCategory(activity.getCategory());
        activityDto.setStartDateAndTime(activity.getStartDateAndTime().toString());
        activityDto.setEndDateAndTime(activity.getEndDateAndTime().toString());
        activityDto.setHospitalId(activity.getHospital().getId());
        activityDto.setStatus(activity.getStatus());
        activityDto.setTitle(activity.getTitle());
        return activityDto;
    }

    public List<ActivityDto> convertModelsToDtos(List<Activity> activities) {
        return activities.stream().map(this::convertModelToDto).collect(Collectors.toList());
    }
}
