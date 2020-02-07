package littlepeople.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportDto extends BaseDto{
    private String description;
    private String category;
    private String title;
    private String text;
    private Long activityId;
}
