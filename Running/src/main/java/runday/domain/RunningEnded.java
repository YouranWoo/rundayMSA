package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RunningEnded extends AbstractEvent {

    private Long id;
    private Date endTime;
    private Long endLatitude;
    private Long endLongitude;
    private Date runningTime;
    private Date totalPauseTime;
    private Date startTime;

    public RunningEnded(Running aggregate) {
        super(aggregate);
    }

    public RunningEnded() {
        super();
    }
}
//>>> DDD / Domain Event
