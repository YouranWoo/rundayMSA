package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import runday.infra.AbstractEvent;

@Data
public class RunningEnded extends AbstractEvent {

    private Long id;
    private Date endTime;
    private Float endLatitude;
    private Float endLongitude;
    private Date runningTime;
    private Date totalPauseTime;
    private Date startTime;
}
