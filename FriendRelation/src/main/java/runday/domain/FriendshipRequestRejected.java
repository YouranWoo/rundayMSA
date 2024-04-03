package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FriendshipRequestRejected extends AbstractEvent {

    private String id;
    private String status;

    public FriendshipRequestRejected(Friends aggregate) {
        super(aggregate);
    }

    public FriendshipRequestRejected() {
        super();
    }
}
//>>> DDD / Domain Event
