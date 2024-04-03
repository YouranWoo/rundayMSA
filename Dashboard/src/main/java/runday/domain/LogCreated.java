package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import runday.infra.AbstractEvent;

@Data
public class LogCreated extends AbstractEvent {

    private Long id;
    private String userId;
    private Date startTime;
    private Long startLatitude;
    private Long startLongitude;
}
