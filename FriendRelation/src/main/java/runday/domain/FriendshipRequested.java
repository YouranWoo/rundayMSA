package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FriendshipRequested extends AbstractEvent {

    private String id;
    private String friendUserId;
    private String status;

    public FriendshipRequested(Friends aggregate) {
        super(aggregate);
    }

    public FriendshipRequested() {
        super();
    }
}
//>>> DDD / Domain Event
