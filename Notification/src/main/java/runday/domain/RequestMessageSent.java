package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RequestMessageSent extends AbstractEvent {

    private Long id;
    private String userId;
    private String message;

    public RequestMessageSent(Message aggregate) {
        super(aggregate);
    }

    public RequestMessageSent() {
        super();
    }
}
//>>> DDD / Domain Event
