package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RunningForcedStop extends AbstractEvent {

    private Long id;
    private Date endTime;

    public RunningForcedStop(Running aggregate) {
        super(aggregate);
    }

    public RunningForcedStop() {
        super();
    }
}
//>>> DDD / Domain Event
