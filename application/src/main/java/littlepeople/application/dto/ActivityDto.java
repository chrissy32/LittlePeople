package littlepeople.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ActivityDto extends BaseDto{
    private String description;
    private String category;
    private String title;
    private String status;
    private String startDateAndTime;
    private String endDateAndTime;
    private Long hospitalId;
}
