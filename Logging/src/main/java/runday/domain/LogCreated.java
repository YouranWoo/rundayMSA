package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LogCreated extends AbstractEvent {

    private Long id;
    private String userId;
    private Date startTime;
    private Long startLatitude;
    private Long startLongitude;

    public LogCreated(Log aggregate) {
        super(aggregate);
    }

    public LogCreated() {
        super();
    }
}
//>>> DDD / Domain Event
