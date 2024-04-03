package runday.domain;

import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

@Data
@ToString
public class FriendshipRequestAccepted extends AbstractEvent {

    private String id;
    private String status;
}
