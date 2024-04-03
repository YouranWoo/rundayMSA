package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import runday.infra.AbstractEvent;

@Data
public class LogCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private Date endTime;
    private Long endLatitude;
    private Long endLongitude;
    private Long runningTime;
}
