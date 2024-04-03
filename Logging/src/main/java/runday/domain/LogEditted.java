package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LogEditted extends AbstractEvent {

    private Long id;
    private String userId;
    private String userDiary;
    private String runningPhoto;

    public LogEditted(Log aggregate) {
        super(aggregate);
    }

    public LogEditted() {
        super();
    }
}
//>>> DDD / Domain Event
