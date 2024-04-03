package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FriendshipRequestAdded extends AbstractEvent {

    private String id;
    private String friendUserId;
    private String status;

    public FriendshipRequestAdded(Friends aggregate) {
        super(aggregate);
    }

    public FriendshipRequestAdded() {
        super();
    }
}
//>>> DDD / Domain Event
