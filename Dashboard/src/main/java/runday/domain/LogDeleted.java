package runday.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import runday.infra.AbstractEvent;

@Data
public class LogDeleted extends AbstractEvent {

    private Long id;
}
