package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LikeUndone extends AbstractEvent {

    private Long id;
    private Integer likeScore;
    private Boolean isLike;

    public LikeUndone(Likes aggregate) {
        super(aggregate);
    }

    public LikeUndone() {
        super();
    }
}
//>>> DDD / Domain Event
