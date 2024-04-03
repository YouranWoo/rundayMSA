package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import runday.infra.AbstractEvent;

@Data
public class RunningForcedStop extends AbstractEvent {

    private Long id;
    private Date endTime;
}
