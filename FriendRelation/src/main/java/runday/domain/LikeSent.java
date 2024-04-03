package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LikeSent extends AbstractEvent {

    private Long id;
    private String userReceivedId;
    private String userSendingId;
    private String runningId;
    private Integer likeScore;

    public LikeSent(Likes aggregate) {
        super(aggregate);
    }

    public LikeSent() {
        super();
    }
}
//>>> DDD / Domain Event
