package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RunningPaused extends AbstractEvent {

    private Long id;
    private Date startTime;
    private Date pauseStartTime;

    public RunningPaused(Running aggregate) {
        super(aggregate);
    }

    public RunningPaused() {
        super();
    }
}
//>>> DDD / Domain Event
