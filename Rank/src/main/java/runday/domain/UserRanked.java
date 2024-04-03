package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserRanked extends AbstractEvent {

    private Long id;
    private String userId;
    private String totalRunningTime;
    private String userRank;

    public UserRanked(Ranking aggregate) {
        super(aggregate);
    }

    public UserRanked() {
        super();
    }
}
//>>> DDD / Domain Event
