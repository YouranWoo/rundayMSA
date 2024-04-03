package runday.domain;

import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

@Data
@ToString
public class RunningStarted extends AbstractEvent {

    private Long id;
    private String userId;
    private Date startTime;
    private Float startLatitude;
    private Float startLongitude;
}
