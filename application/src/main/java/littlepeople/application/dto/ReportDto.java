package littlepeople.application.dto;
import littlepeople.application.model.Activity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReportDto {

    private Activity activity;

    private String text;

}
