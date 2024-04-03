package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RunningRestarted extends AbstractEvent {

    private Long id;
    private Date pauseStartTime;
    private Date pauseEndTime;
    private Date totalPauseTime;

    public RunningRestarted(Running aggregate) {
        super(aggregate);
    }

    public RunningRestarted() {
        super();
    }
}
//>>> DDD / Domain Event
