package littlepeople.application.session;


import lombok.*;

import java.time.Instant;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Session {
    private long userId;
    private String userToken;
    private String username;
    private String email;
    private boolean isAdmin;
    private Instant sessionCreationTime;
}
