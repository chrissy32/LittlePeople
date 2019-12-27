package littlepeople.application.mapper;

import littlepeople.application.dto.ActivityDto;
import littlepeople.application.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityDtoMapper extends AbstractMapper<Activity, ActivityDto> {
    @Autowired
    HospitalDtoMapper hospitalDtoMapper;

    @Autowired
    ReportDtoMapper reportDtoMapper;

    @Override
    public Activity convertDtoToModel(ActivityDto activityDto) {
        return null;
    }

    @Override
    public ActivityDto convertModelToDto(Activity activity) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setId(activity.getId());
        activityDto.setDescription(activity.getDescription());
        activityDto.setCategory(activity.getCategory());
        activityDto.setDateAndTime(activity.getDateAndTime());
        activityDto.setHospitalId(activity.getHospital().getId());
        activityDto.setStatus(activity.getStatus());
        activityDto.setTitle(activity.getTitle());
        return activityDto;
    }

    public List<ActivityDto> convertModelsToDtos(List<Activity> activities) {
        return activities.stream().map(this::convertModelToDto).collect(Collectors.toList());
    }
}
