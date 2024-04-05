package runday.domain;

import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

@Data
@ToString
public class RunningForcedStop extends AbstractEvent {

    private Long id;
    private Date pauseStartTime;
    private Date endTime;

}
