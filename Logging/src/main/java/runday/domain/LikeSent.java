package runday.domain;

import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

@Data
@ToString
public class LikeSent extends AbstractEvent {

    private Long id;
    private String userReceivedId;
    private String userSendingId;
    private String runningId;
    private Integer likeScore;
}
