package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import runday.infra.AbstractEvent;

@Data
public class LogCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private Date startTime;
    private Float startLatitude;
    private Float startLongitude;
    private Date endTime;
    private Float endLatitude;
    private Float endLongitude;
    private Long runningTime;
}
