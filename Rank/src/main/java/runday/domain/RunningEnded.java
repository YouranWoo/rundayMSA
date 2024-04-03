package runday.domain;

import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

@Data
@ToString
public class RunningEnded extends AbstractEvent {

    private Long id;
    private Date endTime;
    private Long endLatitude;
    private Long endLongitude;
    private Date runningTime;
    private Float endLatitude;
    private Float endLongitude;
    private Date totalPauseTime;
    private Date startTime;
}
