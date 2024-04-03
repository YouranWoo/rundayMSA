package runday.domain;

import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

@Data
@ToString
public class LikeUndone extends AbstractEvent {

    private Long id;
    private Integer likeScore;
    private Boolean isLike;
}
