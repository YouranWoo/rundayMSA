package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RunuinngNotifiedToFriends extends AbstractEvent {

    private Long id;
    private String userId;
    private String message;

    public RunuinngNotifiedToFriends(Message aggregate) {
        super(aggregate);
    }

    public RunuinngNotifiedToFriends() {
        super();
    }
}
//>>> DDD / Domain Event
