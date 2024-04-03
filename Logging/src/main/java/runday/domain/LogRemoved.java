package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LogRemoved extends AbstractEvent {

    private Long id;

    public LogRemoved(Log aggregate) {
        super(aggregate);
    }

    public LogRemoved() {
        super();
    }
}
//>>> DDD / Domain Event
