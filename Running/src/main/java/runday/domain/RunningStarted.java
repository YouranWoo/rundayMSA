package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RunningStarted extends AbstractEvent {

    private Long id;
    private String userId;
    private Date startTime;
    private Float startLatitude;
    private Float startLongitude;

    public RunningStarted(Running aggregate) {
        super(aggregate);
    }

    public RunningStarted() {
        super();
    }
}
//>>> DDD / Domain Event
