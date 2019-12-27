package littlepeople.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class ActivityDto extends BaseDto{
    private String description;
    private String category;
    private String title;
    private String status;
    private LocalDateTime dateAndTime;
    private Long hospitalId;
}
