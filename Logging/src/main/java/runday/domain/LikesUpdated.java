package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LikesUpdated extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer likesCount;

    public LikesUpdated(Log aggregate) {
        super(aggregate);
    }

    public LikesUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
