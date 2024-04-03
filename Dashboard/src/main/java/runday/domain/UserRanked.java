package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import runday.infra.AbstractEvent;

@Data
public class UserRanked extends AbstractEvent {

    private Long id;
    private String userId;
    private String totalRunningTime;
    private String userRank;
}
