package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LogCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private Date endTime;
    private Long endLatitude;
    private Long endLongitude;
    private Long runningTime;

    public LogCompleted(Log aggregate) {
        super(aggregate);
    }

    public LogCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
