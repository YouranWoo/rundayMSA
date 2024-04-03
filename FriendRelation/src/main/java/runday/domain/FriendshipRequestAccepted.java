package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FriendshipRequestAccepted extends AbstractEvent {

    private String id;
    private String status;

    public FriendshipRequestAccepted(Friends aggregate) {
        super(aggregate);
    }

    public FriendshipRequestAccepted() {
        super();
    }
}
//>>> DDD / Domain Event
